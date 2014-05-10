package org.cen.robot.device.request;

import java.util.Comparator;

import org.cen.robot.device.request.impl.RobotDeviceRequest;

/**
 * Comparator for request. We use the priority to handle first lowest Priority
 */
public class RobotDeviceRequestComparator implements Comparator<RobotDeviceRequest> {

    @Override
    public int compare(RobotDeviceRequest o1, RobotDeviceRequest o2) {
        int p1 = o1.getPriority();
        int p2 = o2.getPriority();
        if (p1 == p2) {
            return Long.signum(o1.getUID() - o2.getUID());
        } else if (p1 > p2) {
            return -1;
        } else {
            return 1;
        }
    }
}
