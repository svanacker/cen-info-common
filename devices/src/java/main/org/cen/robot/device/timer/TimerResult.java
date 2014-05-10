package org.cen.robot.device.timer;

import org.cen.robot.device.RobotDeviceResult;
import org.cen.robot.device.request.impl.RobotDeviceRequest;

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
	public TimerResult(RobotDeviceRequest request) {
		super(request);
	}
}
