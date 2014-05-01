/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HashUtil {

	private static Logger log = LoggerFactory.getLogger(HashUtil.class);

	/** マルチスレッドは見考慮 */
	private static final MessageDigest MESSAGE_DIGEST;
	
	static {
		MessageDigest md;
		try {
			md =  MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			log.error("SHA", e);
			md = null;
		}
		MESSAGE_DIGEST = md;
	}
	
	public static synchronized String digest(final String word) {
		MESSAGE_DIGEST.update(word.getBytes(Charset.forName("UTF-8")));
		final byte[] b = MESSAGE_DIGEST.digest();
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < b.length; i++) {
			sb.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
}
