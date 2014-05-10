package org.cen.robot.device;

import java.util.EventListener;

/**
 * Listener interface for the robot devices events.
 * 
 * @author Emmanuel ZURMELY
 */
public interface IRobotDeviceListener extends EventListener {

    /**
     * Returns the device name with which this listener is attached to
     * 
     * @return the listened device name
     */
    String getDeviceName();

    /**
     * Method invoked when notifying an event.
     * 
     * @param result
     *            the result obtained from the device
     */
    void handleResult(RobotDeviceResult result);
}
