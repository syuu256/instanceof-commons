/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.daemon;

import static net._instanceof.commons.util.ResourcesUtil.getSystemValue;
import net._instanceof.commons.util.spring.ApplicationContextBuilder;

/**
 * -Dcom.sun.management.jmxremote.authenticate=false 
 * -Dcom.sun.management.jmxremote 
 * -Dcom.sun.management.jmxremote.port=58501 
 * -Dcom.sun.management.jmxremote.ssl=false
 * -Dnet._instanceof.commons.daemon.Bootstrap.main={Spring Beanid}
 */
public final class Bootstrap {
    public static void main(final String[] args) {
        System.exit(new Bootstrap().boot());
    }
    protected int boot() {
        return new ApplicationContextBuilder()
            .createContext()
            .bindJNDI()
            .getApplicationContext()
            .getBean(getSystemValue(Bootstrap.class.getPackage().getName() + ".Bootstrap.main"), Bootable.class)
            .start();
    }
}
