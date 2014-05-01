/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.util;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

/**
 * 
 */
public final class RegisterMBeanUtil {

	private RegisterMBeanUtil(){}

	private static String buildMBeanName(final Object o, final String instanceName) {
		final Class<?> clazz = o.getClass();
		final String packageName = clazz.getPackage().getName();
		String clazzName = clazz.getName();
		final int index = clazzName.lastIndexOf('.');
		if (index != -1)  clazzName = clazzName.substring(index + 1);
		return packageName + ":type=" + clazzName + (instanceName == null ? "" : "." + instanceName);
	}

	public static void registerMBean(final Object mbean) {
		registerMBean(mbean, null);
	}
	
	public static void registerMBean(final Object mbean, final String instanceName) {
		try {
			final MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
			mBeanServer.registerMBean(mbean,
					new ObjectName(buildMBeanName(mbean, instanceName)));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
