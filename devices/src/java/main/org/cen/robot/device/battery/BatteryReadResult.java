package org.cen.robot.device.battery;

import org.cen.robot.device.RobotDeviceResult;
import org.cen.robot.device.request.IRobotDeviceRequest;

public class BatteryReadResult extends RobotDeviceResult {

    private double voltage;

    public BatteryReadResult(IRobotDeviceRequest request) {
        super(request);
    }

    public double getVoltage() {
        return voltage;
    }
}
