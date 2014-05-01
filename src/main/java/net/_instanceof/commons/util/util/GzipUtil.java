/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.util.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GzipUtil {

    private static Logger log = LoggerFactory.getLogger(GzipUtil.class);

    public static byte[] toGzipBin(final byte[] bin) {

        byte [] r = null;
        try (
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            final GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        ) {
            gzipOutputStream.write(bin);
            gzipOutputStream.finish();
            r = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (log.isDebugEnabled()) {
            log.debug("toGzipBin[" + bin.length + "=>" + r.length + "]");
        }

        return r;
    }

    public static byte[] toUnGzipBin(final byte[] bin) {

        byte [] r = null;
        try (
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bin);
            final GZIPInputStream gzipInputStream = new GZIPInputStream(byteArrayInputStream);
        ) {
            byte[] buf = new byte[64];
            int size;
            while ((size = gzipInputStream.read(buf, 0, buf.length)) != -1)  {
                byteArrayOutputStream.write(buf, 0 , size);
            }
            byteArrayOutputStream.flush();
            r = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (log.isDebugEnabled()) {
            log.debug("toUnGzipBin[" + bin.length + "=>" + r.length + "]");
        }

        return r;
    }

}
