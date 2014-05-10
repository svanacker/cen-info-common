package org.cen.robot.device.request;

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

    void sendRequest(IRobotDeviceRequest request);

    void terminate();
}