package org.cen.robot.attributes.impl;

import java.io.InputStream;
import java.util.Properties;

import org.cen.robot.attributes.IMotorProperties;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for {@link MotorProperties}
 */
public class MotorPropertiesTest {

    @Test
    public void should_build_motorProperties() throws Exception {
        Properties properties = new Properties();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream resourceAsStream = classLoader
                .getResourceAsStream("org/cen/robot/attributes/impl/MotorPropertiesTest.properties");
        properties.load(resourceAsStream);

        IMotorProperties motorProperties = new MotorProperties(properties, "dimensions.motors.left.");

        int pulseCount = motorProperties.getPulseCount();

        Assert.assertEquals(20000, pulseCount);
    }
}
