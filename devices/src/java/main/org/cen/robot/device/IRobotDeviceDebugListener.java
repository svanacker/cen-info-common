package org.cen.robot.device;

import java.util.EventListener;

public interface IRobotDeviceDebugListener extends EventListener {

    String getDeviceName();

    void debugEvent(RobotDeviceDebugEvent e);
}
