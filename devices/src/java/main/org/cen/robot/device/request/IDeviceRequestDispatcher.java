package org.cen.robot.device.request;

import org.cen.robot.device.request.impl.RobotDeviceRequest;


public interface IDeviceRequestDispatcher extends Runnable {

    /**
     * Configure the request dispatcher to be in Step by step mode
     * 
     * @param value
     */
    void setStepByStep(boolean value);

    /**
     * Returns if the dispatcher is running or not.
     * 
     * @return
     */
    boolean isRunning();

    void join() throws InterruptedException;

    /**
     * Go to the next Step.
     */
    void nextStep();

    /**
     * Purge the requests.
     */
    void clearRequests();

    void sendRequest(RobotDeviceRequest request);

    void terminate();
}