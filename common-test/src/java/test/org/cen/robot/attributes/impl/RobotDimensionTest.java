package org.cen.robot.attributes.impl;

import java.io.InputStream;
import java.util.Properties;

import org.cen.robot.attributes.IRobotDimension;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for {@link IRobotDimension}
 */
public class RobotDimensionTest {

    @Test
    public void should_build_robotDimension() throws Exception {
        Properties properties = new Properties();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream resourceAsStream = classLoader
                .getResourceAsStream("org/cen/robot/attributes/impl/RobotDimensionTest.properties");
        properties.load(resourceAsStream);

        IRobotDimension robotDimension = new RobotDimension(properties, "dimensions.");

        double weight = robotDimension.getWeight();

        Assert.assertEquals(8, weight, 0.001);
    }
}
