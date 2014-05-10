package org.cen.robot.device.request.impl;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import org.cen.robot.device.IRobotDevice;
import org.cen.robot.device.IRobotDevicesHandler;
import org.cen.robot.device.RobotDeviceResult;
import org.cen.robot.device.request.IDeviceRequestDispatcher;
import org.cen.robot.device.request.IRobotDeviceRequest;
import org.cen.robot.device.request.RobotDeviceRequestComparator;

/**
 * Handle the requests and dispatch them to
 * 
 * @author Stephane
 * 
 */
public class DeviceRequestDispatcher implements IDeviceRequestDispatcher {

    private static final class PurgeRequest extends RobotDeviceRequest {
        public PurgeRequest() {
            super(null);
            priority = Integer.MAX_VALUE;
        }
    }

    private static final class TerminateRequest extends RobotDeviceRequest {

        public TerminateRequest() {
            super(null);
            priority = Integer.MAX_VALUE;
        }
    }

    private final IRobotDevicesHandler handler;

    private final BlockingQueue<IRobotDeviceRequest> queue = new PriorityBlockingQueue<IRobotDeviceRequest>(15,
            new RobotDeviceRequestComparator());

    private boolean running = false;

    private boolean terminated = false;

    private final Thread thread;

    private int uid = 0;

    private boolean stepByStep = false;

    public DeviceRequestDispatcher(IRobotDevicesHandler handler) {
        super();
        this.handler = handler;
        String threadName = getClass().getName();
        thread = new Thread(this, threadName);
        thread.start();
    }

    private void debug(IRobotDevice device, IRobotDeviceRequest request, RobotDeviceResult result) {
        handler.notifyDebug(device, request, result);
    }

    private IRobotDevice getTargetDevice(IRobotDeviceRequest request) {
        String deviceName = request.getDeviceName();
        Map<String, IRobotDevice> devices = handler.getDevices();
        if (devices == null) {
            return null;
        } else {
            return devices.get(deviceName);
        }
    }

    private void handleRequest(IRobotDeviceRequest request) {
        if (request instanceof PurgeRequest) {
            queue.clear();
            return;
        }
        IRobotDevice device = getTargetDevice(request);
        if (device == null) {
            return;
        }
        debug(device, request, null);
        device.handleRequest(request);
    }

    @Override
    public boolean isRunning() {
        return running && !terminated;
    }

    @Override
    public void join() throws InterruptedException {
        thread.join();
    }

    @Override
    public void nextStep() {
        synchronized (this) {
            notify();
        }
    }

    @Override
    public void clearRequests() {
        queue.offer(new PurgeRequest());
    }

    @Override
    public void run() {
        running = true;
        System.out.println("DeviceRequestDispatcher started");
        while (!terminated) {
            try {
                IRobotDeviceRequest request = queue.take();
                handleRequest(request);
                if (stepByStep) {
                    synchronized (this) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                terminated = true;
            }
        }
        System.out.println("DeviceRequestDispatcher terminated");
    }

    @Override
    public void sendRequest(IRobotDeviceRequest request) {
        ((RobotDeviceRequest) request).uid = uid++;
        queue.offer(request);
    }

    @Override
    public void setStepByStep(boolean value) {
        this.stepByStep = value;
    }

    @Override
    public void terminate() {
        terminated = true;
        queue.offer(new TerminateRequest());
    }
}
