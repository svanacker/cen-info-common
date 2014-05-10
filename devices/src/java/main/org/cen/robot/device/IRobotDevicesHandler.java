package org.cen.robot.device;

import java.util.Map;

import org.cen.robot.device.request.IDeviceRequestDispatcher;
import org.cen.robot.device.request.IDeviceResultDispatcher;
import org.cen.robot.device.request.IRobotDeviceRequest;
import org.cen.robot.device.request.impl.RobotDeviceRequest;
import org.cen.robot.services.IRobotService;

/**
 * Robot Devices Container. Able to track the activity of each device, register,
 * unregister them
 * 
 * @author Stephane
 * 
 */
public interface IRobotDevicesHandler extends IRobotService {

    /**
     * Find a device with his name.
     * 
     * @param name
     * @return
     */
    IRobotDevice getDevice(String name);

    /**
     * Get all devices in a map indexed by the name of the device.
     * 
     * @return
     */
    Map<String, IRobotDevice> getDevices();

    /**
     * Get a property of a device.
     * 
     * @param deviceName
     * @param propertyName
     * @return
     */
    Object getProperty(String deviceName, String propertyName);

    IDeviceRequestDispatcher getRequestDispatcher();

    IDeviceResultDispatcher getResultDispatcher();

    /**
     * Register a device.
     * 
     * @param device
     */
    void registerDevice(IRobotDevice device);

    /**
     * Unregister a device.
     * 
     * @param device
     */
    void unregisterDevice(IRobotDevice device);

    void removeDeviceDebugListener(RobotDeviceDebugListener listener);

    void removeDeviceListener(IRobotDeviceListener listener);

    void sendRequest(RobotDeviceRequest request);

    void sendResult(IRobotDevice device, RobotDeviceResult result);

    void setProperty(String deviceName, String propertyName, Object value);

    void addDeviceDebugListener(RobotDeviceDebugListener listener);

    void addDeviceListener(IRobotDeviceListener listener);

    void notifyDebug(IRobotDevice device, IRobotDeviceRequest request, RobotDeviceResult result);

    void notifyListeners(IRobotDevice device, RobotDeviceResult result);
}