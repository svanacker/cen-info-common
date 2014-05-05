package org.cen.robot.device.pid.com;

import org.cen.com.documentation.DeviceDataSignature;
import org.cen.com.documentation.DeviceMethodSignature;
import org.cen.com.documentation.DeviceMethodType;
import org.cen.com.out.OutData;
import org.cen.robot.device.navigation.INavigationDevice;

//@formatter:off
@DeviceDataSignature(deviceName = INavigationDevice.NAME, methods = { 
        @DeviceMethodSignature(
		header = WriteMotionEndDetectionParameterOutData.HEADER, 
		methodName="writeMotionEndDetection",
		type = DeviceMethodType.INPUT,
		parameters = {}) 
        })
//@formatter:on
public class ReadMotionEndDetectionParametersOutData extends OutData {

    final static String HEADER = "~";

    /**
     * Constructor.
     */
    public ReadMotionEndDetectionParametersOutData() {
        super();
    }

    @Override
    public String getHeader() {
        return HEADER;
    }
}