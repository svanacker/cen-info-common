package org.cen.robot.device.request.impl;

import org.cen.robot.device.request.IRobotDeviceRequest;

/**
 * Object representing a request to send to a device of the robot.
 * 
 * @author Emmanuel ZURMELY
 */
public abstract class RobotDeviceRequest implements IRobotDeviceRequest {

    private static int counter = 0;

    private static synchronized long getNextUID() {
        return counter++;
    }

    protected String deviceName;

    protected int priority;

    protected long timeStamp;

    protected long uid;

    /**
     * Constructor.
     */
    public RobotDeviceRequest(String deviceName) {
        super();
        this.deviceName = deviceName;
        uid = getNextUID();
        priority = 0;
        timeStamp = System.currentTimeMillis();
    }

    /**
     * Returns the device name.
     * 
     * @return the device name
     */
    @Override
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * Returns the priority of the request.
     * 
     * @return the priority of the request
     */
    @Override
    public int getPriority() {
        return priority;
    }

    /**
     * Returns the time-stamp of this request.
     * 
     * @return the time-stamp of this request
     */
    @Override
    public long getTimeStamp() {
        return timeStamp;
    }

    @Override
    public long getUID() {
        return uid;
    }
}
