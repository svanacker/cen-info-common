package org.cen.robot.device.motor.com;

import org.cen.com.documentation.DeviceDataSignature;
import org.cen.com.documentation.DeviceMethodSignature;
import org.cen.com.documentation.DeviceMethodType;
import org.cen.com.documentation.DeviceParameter;
import org.cen.com.documentation.DeviceParameterType;
import org.cen.com.out.OutData;
import org.cen.com.utils.ComDataUtils;

/**
 * Encapsulation of a message to manage motors.
 * 
 * @author svanacker
 */
//@formatter:off
@DeviceDataSignature(deviceName = "motor", methods = {
        @DeviceMethodSignature(
		header = MotorOutData.HEADER,
		methodName="move",
		type = DeviceMethodType.INPUT,
		parameters = {
		        @DeviceParameter(name = "left", length = 2, type = DeviceParameterType.SIGNED, unit = ""),
				@DeviceParameter(name = "right", length = 2, type = DeviceParameterType.SIGNED, unit = ""), }) })
//@formatter:on
public class MotorOutData extends OutData {

    protected static final String HEADER = "m";

    /** The speed for left Motor. */
    private final int leftMotor;

    /** The speed for right Motor. */
    private final int rightMotor;

    /**
     * Build an encapsulation of outData from the object model
     */
    public MotorOutData(int leftMotor, int rightMotor) {
        super();
        this.leftMotor = leftMotor;
        this.rightMotor = rightMotor;
    }

    @Override
    public String getArguments() {
        // First Argument
        String leftMotorString = ComDataUtils.format(leftMotor, 2);
        // Second Argument
        String rightMotorString = ComDataUtils.format(rightMotor, 2);
        return leftMotorString + rightMotorString;
    }

    @Override
    public String getHeader() {
        return HEADER;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[leftMotor=" + leftMotor + ", rightMotor=" + rightMotor + "]";
    }
}
