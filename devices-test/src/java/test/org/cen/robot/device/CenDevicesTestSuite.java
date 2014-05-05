package org.cen.robot.device;

import org.cen.robot.device.lcd.LcdDeviceTest;
import org.cen.robot.device.navigation.com.NavigationDataDecoderTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = { LcdDeviceTest.class, NavigationDataDecoderTest.class })
public class CenDevicesTestSuite {

}
