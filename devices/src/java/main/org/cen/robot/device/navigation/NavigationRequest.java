package org.cen.robot.device.navigation;

import org.cen.robot.device.request.impl.RobotDeviceRequest;

public abstract class NavigationRequest extends RobotDeviceRequest {

    public NavigationRequest() {
        super(INavigationDevice.NAME);
    }
}
