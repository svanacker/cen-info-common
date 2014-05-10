package org.cen.robot.device.configuration;

import org.cen.robot.device.request.impl.RobotDeviceRequest;

public abstract class ConfigurationRequest extends RobotDeviceRequest {
	public ConfigurationRequest() {
		super(ConfigurationDevice.NAME);
	}
}
