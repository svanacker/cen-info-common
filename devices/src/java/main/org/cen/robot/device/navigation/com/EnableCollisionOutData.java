package org.cen.robot.device.navigation.com;

import org.cen.com.out.OutData;
import org.cen.com.utils.ComDataUtils;

public class EnableCollisionOutData extends OutData {
	private boolean enabled;

	private static final String HEADER = "<";

	public EnableCollisionOutData(boolean enabled) {
		super();
		this.enabled = enabled;
	}

	@Override
	public String getArguments() {
		int value = (enabled) ? 1 : 0;
		return ComDataUtils.format(value, 2);
	}

	@Override
	public String getHeader() {
		return HEADER;
	}
}
