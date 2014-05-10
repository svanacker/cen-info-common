package org.cen.robot.device.battery;

import org.cen.com.IComService;
import org.cen.com.out.OutData;
import org.cen.robot.device.AbstractRobotDevice;
import org.cen.robot.device.battery.com.BatteryReadOutData;
import org.cen.robot.device.request.IRobotDeviceRequest;
import org.cen.robot.services.IRobotServiceProvider;

public class BatteryDevice extends AbstractRobotDevice {
    public static final String NAME = "battery";

    public BatteryDevice(String name) {
        super(NAME);
    }

    @Override
    public void initialize(IRobotServiceProvider servicesProvider) {
        super.initialize(servicesProvider);
        IComService comService = servicesProvider.getService(IComService.class);
        comService.getDecodingService().registerDecoder(new BatteryDataDecoder());
    }

    @Override
    protected void internalHandleRequest(IRobotDeviceRequest request) {
        if (request instanceof BatteryReadRequest) {
            send(new BatteryReadOutData());
        }
    }

    private void send(OutData outData) {
        IComService comService = servicesProvider.getService(IComService.class);
        comService.writeOutData(outData);
    }
}
