package org.cen.robot.device.request.impl;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.cen.robot.device.IRobotDevice;
import org.cen.robot.device.IRobotDevicesHandler;
import org.cen.robot.device.RobotDeviceResult;
import org.cen.robot.device.request.IDeviceResultDispatcher;

public class DeviceResultDispatcher implements IDeviceResultDispatcher {

    private class RobotDeviceResultNotification {
        public IRobotDevice device;

        public RobotDeviceResult result;

        public RobotDeviceResultNotification(IRobotDevice device, RobotDeviceResult result) {
            super();
            this.device = device;
            this.result = result;
        }
    }

    private final class TerminateNotification extends RobotDeviceResultNotification {
        public TerminateNotification() {
            super(null, null);
        }
    }

    private final IRobotDevicesHandler handler;

    private final BlockingQueue<RobotDeviceResultNotification> queue = new ArrayBlockingQueue<RobotDeviceResultNotification>(
            15);

    private boolean running = false;

    private boolean terminated = false;

    private final Thread thread;

    public DeviceResultDispatcher(IRobotDevicesHandler handler) {
        super();
        this.handler = handler;
        thread = new Thread(this, getClass().getName());
        thread.start();
    }

    private void handleNotification(RobotDeviceResultNotification notification) {
        IRobotDevice device = notification.device;
        RobotDeviceResult result = notification.result;
        handler.notifyDebug(device, (result == null) ? null : result.getRequest(), result);
        handler.notifyListeners(device, result);
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
    public void notifyResult(IRobotDevice device, RobotDeviceResult result) {
        RobotDeviceResultNotification notification = new RobotDeviceResultNotification(device, result);
        queue.offer(notification);
    }

    @Override
    public void run() {
        running = true;
        System.out.println("DeviceResultDispatcher started");
        while (!terminated) {
            try {
                RobotDeviceResultNotification notification = queue.take();
                if (notification instanceof TerminateNotification) {
                    break;
                }
                handleNotification(notification);
            } catch (InterruptedException e) {
                e.printStackTrace();
                terminated = true;
            }
        }
        System.out.println("DeviceResultDispatcher terminated");
    }

    @Override
    public void terminate() {
        terminated = true;
        queue.offer(new TerminateNotification());
    }
}
