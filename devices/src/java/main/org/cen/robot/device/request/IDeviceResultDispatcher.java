package org.cen.robot.device.request;

import org.cen.robot.device.IRobotDevice;
import org.cen.robot.device.RobotDeviceResult;

public interface IDeviceResultDispatcher extends Runnable {

    boolean isRunning();

    void join() throws InterruptedException;

    void nextStep();

    void notifyResult(IRobotDevice device, RobotDeviceResult result);

    void terminate();
}