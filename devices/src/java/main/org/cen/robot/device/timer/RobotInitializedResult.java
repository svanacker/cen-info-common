package org.cen.robot.device.timer;

import org.cen.robot.device.request.IRobotDeviceRequest;

/**
 * Result object indicating that the robot is initialized.
 * 
 * @author Emmanuel ZURMELY
 */
public class RobotInitializedResult extends TimerResult {
    /**
     * Constructor.
     * 
     * @param request
     *            the request object of which this object is the result
     */
    public RobotInitializedResult(IRobotDeviceRequest request) {
        super(request);
    }
}
