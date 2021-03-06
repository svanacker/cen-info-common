package org.cen.robot.device.configuration;

import org.cen.com.IComService;
import org.cen.com.in.InData;
import org.cen.com.in.InDataListener;
import org.cen.robot.device.AbstractRobotDevice;
import org.cen.robot.device.IRobotDevicesHandler;
import org.cen.robot.device.configuration.com.ConfigurationDataDecoder;
import org.cen.robot.device.configuration.com.ConfigurationReadInData;
import org.cen.robot.device.configuration.com.ConfigurationReadOutData;
import org.cen.robot.device.request.IRobotDeviceRequest;
import org.cen.robot.services.IRobotServiceProvider;

public class ConfigurationDevice extends AbstractRobotDevice implements InDataListener, IConfigurationDevice {

    private ConfigurationRequest request;

    /**
     * Constructor.
     */
    public ConfigurationDevice() {
        super(NAME);
    }

    /**
     * Constructor for a cup specific implementation.
     * 
     * @param name
     *            the name of the device
     */
    protected ConfigurationDevice(String name) {
        super(name);
    }

    @Override
    public void debug(String debugAction) {
        if (debugAction.equals("read")) {
            sendData(new ConfigurationReadRequest());
        }
    }

    private ConfigurationResult getResult(ConfigurationReadInData data) {
        return new ConfigurationReadResult(request, data.getValue());
    }

    @Override
    public void initialize(IRobotServiceProvider servicesProvider) {
        this.servicesProvider = servicesProvider;
        IComService comService = servicesProvider.getService(IComService.class);
        comService.getDecodingService().registerDecoder(new ConfigurationDataDecoder());
        comService.addInDataListener(this);
    }

    @Override
    protected void internalHandleRequest(IRobotDeviceRequest request) {
        if (request instanceof ConfigurationReadRequest) {
            sendData((ConfigurationRequest) request);
        }
    }

    protected void notifyResult(ConfigurationResult result) {
        IRobotDevicesHandler handler = servicesProvider.getService(IRobotDevicesHandler.class);
        handler.sendResult(this, result);
    }

    @Override
    public void onInData(InData data) {
        if (data instanceof ConfigurationReadInData) {
            ConfigurationResult configurationResult = getResult((ConfigurationReadInData) data);
            notifyResult(configurationResult);
        }
    }

    private void sendData(ConfigurationRequest request) {
        this.request = request;
        IComService comService = servicesProvider.getService(IComService.class);
        comService.writeOutData(new ConfigurationReadOutData());
    }
}
