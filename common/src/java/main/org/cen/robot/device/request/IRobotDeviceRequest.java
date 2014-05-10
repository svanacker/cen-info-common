package org.cen.robot.device.request;

/**
 * Representing a request to send to a device of the robot.
 * 
 * @author Emmanuel ZURMELY
 */
public interface IRobotDeviceRequest {

    /**
     * Returns the device name.
     * 
     * @return the device name
     */
    String getDeviceName();

    /**
     * Returns the priority of the request.
     * 
     * @return the priority of the request
     */
    int getPriority();

    /**
     * Returns the time-stamp of this request.
     * 
     * @return the time-stamp of this request
     */
    long getTimeStamp();

    /**
     * Uid to differentiate the device requests.
     * 
     * @return
     */
    long getUID();
}
