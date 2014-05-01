/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.daemon;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 * 
 */
public class Shutdown {

	private static final String JMX_URL = "service:jmx:rmi:///jndi/rmi://";
	
	public static void main(final String[] args) {
		int r = 1;
		try {
			r = new Shutdown().down();
		} catch (Exception e) {
			e.printStackTrace();
		}
		log("exit:" + r);
		System.exit(r);
	}

	private static void log(final String message) {
		final String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
		System.out.println("" + time + " [INFO ] main Shutdown - " + message);
	}

	private Properties load() throws IOException {
		final Properties properties = new Properties();
		properties.load(Shutdown.class.getResourceAsStream("/shutdown.properties"));
		return properties;
	}
	
	private int down() throws Exception {
		
		final Properties properties = load();
		for (final Map.Entry<?, ?> entry : properties.entrySet()) {
			log("properties[" + entry.getKey() + ":" + entry.getValue() + "]");
		}
		
		final String host = properties.getProperty("host");
		final String port = properties.getProperty("port");
		final String objectNamePath = properties.getProperty("objectNamePath");
		final String operationName = properties.getProperty("operationName");
		final String serviceURL = JMX_URL + host + ":" + port + "/jmxrmi";

		log("(01) JMXServiceURL/serviceURL:" + serviceURL);
		final JMXServiceURL jmxServiceURL = new JMXServiceURL(serviceURL);
		
		log("(02) JMXConnector/jmxServiceURL:" + jmxServiceURL);
		final JMXConnector jmxConnector = JMXConnectorFactory.connect(jmxServiceURL);
		
		log("(03) MBeanServerConnection");
		final MBeanServerConnection mbeanServerConnection = jmxConnector.getMBeanServerConnection();
		
		log("(04) ObjectName");
		final ObjectName objectName = new ObjectName(objectNamePath);
		
		log("(05) invoke:" + operationName + ":" + objectName);
		final Object r = mbeanServerConnection.invoke(objectName, operationName, new Object[]{}, new String[]{});
		log("(06) invokeResult:" + r);

		jmxConnector.close();

		return 0;
	}
}
