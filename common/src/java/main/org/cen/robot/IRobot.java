package org.cen.robot;

import java.util.List;

import org.cen.robot.attributes.IRobotAttribute;
import org.cen.robot.configuration.IRobotConfiguration;
import org.cen.robot.device.IRobotDevice;

/**
 * Interface of the robot object.
 * 
 * @author Emmanuel ZURMELY
 */
public interface IRobot {

    /**
     * Returns the attribute value coresponding to the given attribute class.
     * 
     * @param attributeType
     *            the type of the robot attribute to retrieve
     * @return the attribute value
     */
    <E extends IRobotAttribute> E getAttribute(Class<E> attributeType);

    /**
     * Returns the list of the attributes of the robot.
     * 
     * @return the list of the attributes
     */
    List<IRobotAttribute> getAttributes();

    /**
     * Returns the configuration of the robot.
     * 
     * @return the configuration of the robot
     */
    IRobotConfiguration getConfiguration();

    /**
     * Returns the list of the devices.
     * 
     * @return the list of the devices
     */
    List<IRobotDevice> getDevices();

    /**
     * Returns the name of the robot.
     * 
     * @return the name of the robot
     */
    String getName();

    /**
     * Sets the configuration of the robot.
     * 
     * @param configuration
     *            the configuration of the robot
     */
    void setConfiguration(IRobotConfiguration configuration);

    /**
     * Sets the device list of the robot.
     * 
     * @param devices
     *            the device list of the robot
     */
    void setDevices(List<IRobotDevice> devices);
}
