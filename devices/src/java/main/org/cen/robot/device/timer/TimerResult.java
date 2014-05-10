package org.cen.robot.device.timer;

import org.cen.robot.device.RobotDeviceResult;
import org.cen.robot.device.request.IRobotDeviceRequest;

/**
 * Abstract base class of the result objects of the timer device.
 * 
 * @author Emmanuel ZURMELY
 */
public abstract class TimerResult extends RobotDeviceResult {
    /**
     * Constructor.
     * 
     * @param request
     *            the request object of this result
     */
    public TimerResult(IRobotDeviceRequest request) {
        super(request);
    }
}
