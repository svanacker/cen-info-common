package org.cen.robot.device;

import java.util.Map;

import org.cen.robot.IRobotServiceProvider;

public interface IRobotDevice {

    String getName();

    Map<String, ?> getProperties();

    Object getProperty(String name);

    void handleRequest(RobotDeviceRequest request);

    void initialize(IRobotServiceProvider servicesProvider);

    boolean isEnabled();

    void setEnabled(boolean enabled);

    void setProperty(String propertyName, Object value);
}
