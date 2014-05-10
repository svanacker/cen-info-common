package org.cen.robot.device.request;

import java.util.Comparator;

/**
 * Comparator for request. We use the priority to handle first lowest Priority
 */
public class RobotDeviceRequestComparator implements Comparator<IRobotDeviceRequest> {

    @Override
    public int compare(IRobotDeviceRequest o1, IRobotDeviceRequest o2) {
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
