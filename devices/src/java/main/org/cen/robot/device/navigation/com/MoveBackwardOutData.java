package org.cen.robot.device.navigation.com;

import org.cen.com.ComDataUtils;
import org.cen.com.documentation.DeviceDataSignature;
import org.cen.com.documentation.DeviceMethodSignature;
import org.cen.com.documentation.DeviceMethodType;
import org.cen.com.documentation.DeviceParameter;
import org.cen.com.documentation.DeviceParameterType;
import org.cen.com.out.OutData;
import org.cen.robot.device.navigation.INavigationDevice;

/**
 * Corresponds to the data which is sent to the COM stream to go backward the
 * robot.
 */
//@formatter:off
@DeviceDataSignature(deviceName = INavigationDevice.NAME, methods = {
        @DeviceMethodSignature(
		header = MoveBackwardOutData.HEADER,
		methodName="moveBackward",
		type = DeviceMethodType.INPUT,
		parameters = { @DeviceParameter(
				name = "distance",
				length = 4,
				type = DeviceParameterType.SIGNED,
				unit = "distance in mm"), })
        })
//@formatter:on
public class MoveBackwardOutData extends OutData {

    public static final String HEADER = "b";

    /**
     * The angle for rotation.
     */
    protected double distance;

    /**
     * Constructor with all arguments.
     */
    public MoveBackwardOutData(double distance) {
        this.distance = distance;
    }

    @Override
    public String getArguments() {
        String argumentString = ComDataUtils.format((int) distance, 4);

        return argumentString;
    }

    @Override
    public String getDebugString() {
        return "{distance=" + distance + "}";
    }

    @Override
    public String getHeader() {
        return HEADER;
    }
}
