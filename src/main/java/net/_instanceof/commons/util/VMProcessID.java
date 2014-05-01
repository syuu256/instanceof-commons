/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.util;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * プロセスID取得(マルチプロセス識別子).
 */
public class VMProcessID {

	private static final VMProcessID instance = new VMProcessID();

	private String id = "";

	private VMProcessID(){
		id = getJMUniqueId();
	}

	public static VMProcessID getInstance() {
		return instance;
	}

	public String id() {
		return id;
	}

	private String getJMUniqueId() {
		final RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
		final String[] names = runtimeMXBean.getName().split("@");
		if (names == null || names.length < 2) {
			throw new RuntimeException("RuntimeMXBean:" + runtimeMXBean.getName());
		}
		return names[0];
	}
	
	@Override
	public String toString() {
		return id;
	}
}
