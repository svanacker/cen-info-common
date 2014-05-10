package org.cen.robot.device;

import org.cen.robot.device.request.IRobotDeviceRequest;

/**
 * Object representing the result of the treatment of a request by a device of
 * the robot.
 * 
 * @author Emmanuel ZURMELY
 */
public abstract class RobotDeviceResult extends RobotDeviceEvent {

    protected IRobotDeviceRequest request;

    /**
     * Constructor.
     * 
     * @param request
     *            the request associated to this result
     */
    public RobotDeviceResult(IRobotDeviceRequest request) {
        super();
        this.request = request;
    }

    /**
     * The request corresponding to this result object.
     * 
     * @return the request corresponding to this result object
     */
    public IRobotDeviceRequest getRequest() {
        return request;
    }
}
