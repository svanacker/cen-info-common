package org.cen.robot.configuration;

import java.util.Properties;

/**
 * Interface for manipulating the robot configuration. The robot configuration
 * consists of a properties set.
 * 
 * @author Emmanuel ZURMELY
 */
public interface IRobotConfiguration {

    /**
     * Returns the properties set.
     * 
     * @return the properties set
     */
    Properties getProperties();

    /**
     * Returns a property value.
     * 
     * @param key
     *            the property key
     * @return the property value or null if the property does not exist
     */
    String getProperty(String key);

    /**
     * Sets a property.
     * 
     * @param key
     *            the property key
     * @param value
     *            the new property value
     */
    void setProperty(String key, String value);
}
