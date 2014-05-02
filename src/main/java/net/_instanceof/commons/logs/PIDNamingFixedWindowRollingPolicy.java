/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.logs;

import net._instanceof.commons.util.VMProcessID;
import ch.qos.logback.core.rolling.FixedWindowRollingPolicy;

/**
 * 
 */
public class PIDNamingFixedWindowRollingPolicy extends FixedWindowRollingPolicy {

	public void setFileNamePattern(String file) {
		final String fix = getJMUniqueId();
		if (file.endsWith(".log")) {
			file = file.substring(0, file.length() - ".log".length());
		}
		file +=  "-" + fix + ".log";
		super.setFileNamePattern(file);
	}

	public String getJMUniqueId() {
		return VMProcessID.getInstance().id();
	}
}
