package net._instanceof.commons.daemon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

public class BootstrapTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testMain() {

		System.setProperty("java.naming.provider.url", "jndi_junit.xml");
		System.setProperty("net._instanceof.commons.util.spring.xml", "junit_applicationContext.xml");
		System.setProperty("net._instanceof.commons.daemon.Bootstrap.main", "BootableMock");
		
		Bootstrap.main(null);
		
		
	}

	public static void main(String[] arg) throws Exception {
		
	    Logger log = LoggerFactory.getLogger(BootstrapTest.class);

	    for (int i = 0; i < Integer.MAX_VALUE; i++) {
	    	log.error("aaaaaaaaaaaaaaa");
	    }
	    
		System.setProperty("java.naming.provider.url", "jndi_junit.xml");
		System.setProperty("net._instanceof.commons.util.spring.xml", "junit_applicationContext.xml");
		System.setProperty("net._instanceof.commons.daemon.Bootstrap.main", "BootableMock");
		
		Bootstrap.main(null);
	}
}
@Component
class BootableMock implements Bootable {

	@Override
	public int start() {
		System.out.println("aiueo");
		return Integer.MAX_VALUE;
	}
	
}