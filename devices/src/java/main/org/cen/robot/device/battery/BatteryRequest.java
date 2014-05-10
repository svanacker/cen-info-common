package org.cen.robot.device.battery;

import org.cen.robot.device.request.impl.RobotDeviceRequest;

public class BatteryRequest extends RobotDeviceRequest {
	public BatteryRequest() {
		super(BatteryDevice.NAME);
	}
}
