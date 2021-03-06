package org.cen.robot.device;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.swing.event.EventListenerList;

import org.cen.robot.device.request.IDeviceRequestDispatcher;
import org.cen.robot.device.request.IDeviceResultDispatcher;
import org.cen.robot.device.request.IRobotDeviceRequest;
import org.cen.robot.device.request.impl.DeviceRequestDispatcher;
import org.cen.robot.device.request.impl.DeviceResultDispatcher;
import org.cen.robot.services.IRobotService;
import org.cen.robot.services.IRobotServiceProvider;

/**
 * Default implementation of {@link IRobotDevicesHandler}.
 */
public class RobotDevicesHandler implements IRobotService, IRobotDevicesHandler {

    private Map<String, IRobotDevice> devices;

    private IDeviceRequestDispatcher requestsDispatcher;

    private IDeviceResultDispatcher resultsDispatcher;

    private EventListenerList listeners;

    public RobotDevicesHandler() {
        super();
    }

    @Override
    public void addDeviceDebugListener(IRobotDeviceDebugListener listener) {
        listeners.add(IRobotDeviceDebugListener.class, listener);
    }

    @Override
    public void addDeviceListener(IRobotDeviceListener listener) {
        listeners.add(IRobotDeviceListener.class, listener);
    }

    @Override
    public IRobotDevice getDevice(String name) {
        return devices.get(name);
    }

    @Override
    public Map<String, IRobotDevice> getDevices() {
        return devices;
    }

    @Override
    public Object getProperty(String deviceName, String propertyName) {
        IRobotDevice device = getDevice(deviceName);
        if (device != null) {
            return device.getProperty(propertyName);
        } else {
            return null;
        }
    }

    @Override
    public IDeviceRequestDispatcher getRequestDispatcher() {
        return requestsDispatcher;
    }

    @Override
    public IDeviceResultDispatcher getResultDispatcher() {
        return resultsDispatcher;
    }

    @PostConstruct
    protected void initialize() {
        devices = new HashMap<String, IRobotDevice>();
        listeners = new EventListenerList();
        requestsDispatcher = new DeviceRequestDispatcher(this);
        resultsDispatcher = new DeviceResultDispatcher(this);
    }

    @Override
    public void notifyDebug(IRobotDevice device, IRobotDeviceRequest request, RobotDeviceResult result) {
        // Guaranteed to return a non-null array
        Object[] l = listeners.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = l.length - 2; i >= 0; i -= 2) {
            if (l[i] == IRobotDeviceDebugListener.class) {
                IRobotDeviceDebugListener listener = ((IRobotDeviceDebugListener) l[i + 1]);
                String listenerDeviceName = listener.getDeviceName();
                String deviceName = device.getName();
                if (listenerDeviceName.equals(deviceName)) {
                    listener.debugEvent(new RobotDeviceDebugEvent(request, result));
                }
            }
        }
    }

    @Override
    public void notifyListeners(IRobotDevice device, RobotDeviceResult result) {
        // Guaranteed to return a non-null array
        Object[] l = listeners.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = l.length - 2; i >= 0; i -= 2) {
            if (l[i] == IRobotDeviceListener.class) {
                IRobotDeviceListener listener = ((IRobotDeviceListener) l[i + 1]);
                String deviceName = device.getName();
                if (deviceName.equals(listener.getDeviceName())) {
                    listener.handleResult(result);
                }
            }
        }
        notifyDebug(device, result.request, result);
    }

    @Override
    public void registerDevice(IRobotDevice device) {
        devices.put(device.getName(), device);
    }

    @Override
    public void removeDeviceDebugListener(IRobotDeviceDebugListener listener) {
        listeners.remove(IRobotDeviceDebugListener.class, listener);
    }

    @Override
    public void removeDeviceListener(IRobotDeviceListener listener) {
        listeners.remove(IRobotDeviceListener.class, listener);
    }

    @Override
    public void sendRequest(IRobotDeviceRequest request) {
        requestsDispatcher.sendRequest(request);
    }

    @Override
    public void sendResult(IRobotDevice device, RobotDeviceResult result) {
        resultsDispatcher.notifyResult(device, result);
    }

    @Override
    public void setProperty(String deviceName, String propertyName, Object value) {
        IRobotDevice device = getDevice(deviceName);
        if (device != null) {
            device.setProperty(propertyName, value);
        }
    }

    @Override
    public void setServicesProvider(IRobotServiceProvider provider) {
        provider.registerService(IRobotDevicesHandler.class, this);
    }

    @PreDestroy
    protected void shutdown() {
        if (requestsDispatcher != null) {
            requestsDispatcher.terminate();
            requestsDispatcher = null;
        }
        if (resultsDispatcher != null) {
            resultsDispatcher.terminate();
            resultsDispatcher = null;
        }
        if (listeners != null) {
            listeners = null;
        }
        if (devices != null) {
            devices.clear();
            devices = null;
        }
    }

    @Override
    public void unregisterDevice(IRobotDevice device) {
        String deviceName = device.getName();
        devices.remove(deviceName);
    }
}
