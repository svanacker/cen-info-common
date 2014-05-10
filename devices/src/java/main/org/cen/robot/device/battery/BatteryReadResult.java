package org.cen.robot.device.battery;

import org.cen.robot.device.RobotDeviceResult;
import org.cen.robot.device.request.impl.RobotDeviceRequest;

public class BatteryReadResult extends RobotDeviceResult {
	private double voltage;

	public BatteryReadResult(RobotDeviceRequest request) {
		super(request);
	}

	public double getVoltage() {
		return voltage;
	}
}
