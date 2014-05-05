package org.cen.robot.device.navigation;

import org.cen.com.out.OutDataSender;
import org.cen.robot.device.IRobotDevice;
import org.cen.robot.device.navigation.com.CalibrationOutData;
import org.cen.robot.device.navigation.com.MoveBackwardOutData;
import org.cen.robot.device.navigation.com.MoveForwardOutData;
import org.cen.robot.device.navigation.com.MoveOutData;
import org.cen.robot.device.navigation.com.RotateLeftOneWheelOutData;
import org.cen.robot.device.navigation.com.RotateLeftOutData;
import org.cen.robot.device.navigation.com.RotateRightOneWheelOutData;
import org.cen.robot.device.navigation.com.RotateRightOutData;
import org.cen.robot.device.navigation.com.StopOutData;
import org.cen.robot.device.navigation.position.com.ReadPositionPulseOutData;
import org.cen.robot.device.navigation.position.com.SetInitialPositionOutData;
import org.cen.robot.device.pid.com.ReadPIDOutData;
import org.cen.robot.device.pid.com.WritePIDOutData;

@OutDataSender(classes = { MoveForwardOutData.class, MoveBackwardOutData.class, RotateLeftOutData.class,
        RotateRightOutData.class, RotateLeftOneWheelOutData.class, RotateRightOneWheelOutData.class, MoveOutData.class,
        StopOutData.class, ReadPIDOutData.class, ReadPositionPulseOutData.class, SetInitialPositionOutData.class,
        StopOutData.class, WritePIDOutData.class, CalibrationOutData.class })
public interface INavigationDevice extends IRobotDevice {

    public static final String NAME = "navigation";
}
