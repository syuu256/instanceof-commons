/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.util;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;
import com.google.common.io.Resources;

public class ResourcesUtil {

    private static Logger log = LoggerFactory.getLogger(ResourcesUtil.class);

    private static Map<String, String> map = Maps.newHashMap();


    /**
     * クラスパスのファイルをStringで戻す
     * @param name
     * @return
     * @throws Exception
     */
    public static String loadResource(final String name) throws Exception {

        String r = null;
        synchronized (ResourcesUtil.class) {
            r = map.get(name);
            if (r != null) return r;
            r = Resources.toString(new URL("file://" + name), Charset.forName("UTF-8"));
            map.put(name, r);
        }

        if (r == null) {
            if (log.isErrorEnabled()) {
                log.error("READ:File:loadResource:" + name);
            }
            throw new RuntimeException("READ:File:loadResource:" + name);
        }

        return r;
    }

    public static String getSystemValue(final String key, final String def) {
        final String value = System.getProperty(key, def);
        // non equals
        if (value == def) {
            final String msg = "unset system parameter [-D" + key + "={$foo}]";
            if (log.isWarnEnabled()) {
                log.warn(msg);
            }
        }
        if (log.isInfoEnabled()) {
            log.info("-D" + key + "=" + value);
        }
        return value;
    }
    public static String getSystemValue(final String key) {
        final String value = System.getProperty(key);
        if (value == null) {
            final String msg = "unset system parameter [-D" + key + "={$foo}]";
            if (log.isErrorEnabled()) {
                log.error(msg);
            }
            throw new RuntimeException(msg);
        }
        if (log.isInfoEnabled()) {
            log.info("-D" + key + "=" + value);
        }
        return value;
    }

}
