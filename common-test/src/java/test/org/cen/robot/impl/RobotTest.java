package org.cen.robot.impl;

import org.junit.Test;

public class RobotTest {

    @Test
    public void should_build_Robot() {
        AbstractRobot robot = new AbstractRobot() {

            @Override
            public String getName() {
                return "RobotTest";
            }
        };
    }
}
