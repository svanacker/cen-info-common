package org.cen.robot.device;

import org.cen.robot.device.request.IRobotDeviceRequest;

public class RobotDeviceDebugEvent {

    protected IRobotDeviceRequest request;

    protected RobotDeviceResult result;

    public RobotDeviceDebugEvent(IRobotDeviceRequest request, RobotDeviceResult result) {
        super();
        this.request = request;
        this.result = result;
    }

    public IRobotDeviceRequest getRequest() {
        return request;
    }

    public RobotDeviceResult getResult() {
        return result;
    }
}
