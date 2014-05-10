package org.cen.robot.device;

import java.util.Map;

import org.cen.robot.device.request.IRobotDeviceRequest;
import org.cen.robot.services.IRobotServiceProvider;

/**
 * Encapsulate a device for a Robot (Ex : Servo, Arm, Motor Controller).
 */
public interface IRobotDevice {

    /**
     * The name of the device.
     * 
     * @return
     */
    String getName();

    /**
     * Unstructured device information
     * 
     * @return
     */
    Map<String, ?> getProperties();

    /**
     * Return a specific property by a name.
     * 
     * @param name
     *            property name.
     * @return
     */
    Object getProperty(String name);

    /**
     * Set a property value by its name
     * 
     * @param propertyName
     *            the name of the property
     * @param value
     *            the value.
     */
    void setProperty(String propertyName, Object value);

    /**
     * Initialization of the device.
     * 
     * @param servicesProvider
     */
    void initialize(IRobotServiceProvider servicesProvider);

    /**
     * Handle a request for that Device.
     * 
     * @param request
     */
    void handleRequest(IRobotDeviceRequest request);

    /**
     * Is the device enabled or not.
     * 
     * @return
     */
    boolean isEnabled();

    void setEnabled(boolean enabled);

}
