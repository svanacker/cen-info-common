package org.cen.robot.device.shutdown;

import org.cen.com.IComService;
import org.cen.com.in.InData;
import org.cen.com.in.InDataListener;
import org.cen.robot.device.AbstractRobotDevice;
import org.cen.robot.device.request.IRobotDeviceRequest;
import org.cen.robot.device.shutdown.com.ShutdownDataDecoder;
import org.cen.robot.device.shutdown.com.ShutdownInData;
import org.cen.robot.services.IRobotServiceProvider;

/**
 * Device for handling the computer shut down.
 */
public class ShutdownDevice extends AbstractRobotDevice implements InDataListener, IShutdownDevice {

    /**
     * Constructor.
     */
    public ShutdownDevice() {
        super(IShutdownDevice.NAME);
    }

    @Override
    public void debug(String debugAction) {
    }

    @Override
    public void initialize(IRobotServiceProvider servicesProvider) {
        super.initialize(servicesProvider);
        IComService comService = servicesProvider.getService(IComService.class);
        comService.getDecodingService().registerDecoder(new ShutdownDataDecoder());
        comService.addInDataListener(this);
    }

    @Override
    protected void internalHandleRequest(IRobotDeviceRequest request) {
    }

    @Override
    public void onInData(InData data) {
        if (data instanceof ShutdownInData) {
            String[] args = new String[2];
            args[0] = "shutdown";
            args[1] = "-s";
            try {
                Runtime.getRuntime().exec(args);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
