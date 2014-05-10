package org.cen.robot.configuration.impl;

import java.util.Properties;

import org.cen.robot.configuration.IRobotConfiguration;

/**
 * {@link IRobotConfiguration} default implementation.
 * @author Stephane
 *
 */
public class RobotConfiguration implements IRobotConfiguration {
	
	private Properties properties;

	public RobotConfiguration() {
		super();
		properties = new Properties();
	}

	public Properties getProperties() {
		return properties;
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	public void setProperty(String key, String value) {
		properties.setProperty(key, value);
	}
}
