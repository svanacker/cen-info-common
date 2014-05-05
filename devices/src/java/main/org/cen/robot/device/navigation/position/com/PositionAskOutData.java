package org.cen.robot.device.navigation.position.com;

import org.cen.com.documentation.DeviceDataSignature;
import org.cen.com.documentation.DeviceMethodSignature;
import org.cen.com.documentation.DeviceMethodType;
import org.cen.com.out.OutData;
import org.cen.robot.device.navigation.INavigationDevice;

/**
 * Encapsulation of the message which ask for absolute Position.
 */
//@formatter:off
@DeviceDataSignature(deviceName = INavigationDevice.NAME, methods = { @DeviceMethodSignature(
		header = PositionAskOutData.HEADER,
		methodName = "positionRead",
		type = DeviceMethodType.OUTPUT,
		parameters = {}) })
//@formatter:on		
public class PositionAskOutData extends OutData {

    public final static String HEADER = "h";

    /**
     * Constructor.
     */
    public PositionAskOutData() {
        super();
    }

    @Override
    public String getHeader() {
        return HEADER;
    }
}
