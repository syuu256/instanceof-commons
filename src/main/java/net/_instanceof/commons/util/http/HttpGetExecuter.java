/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.util.http;

import java.net.URI;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HttpGetのラッパー
 */
public class HttpGetExecuter extends AbstractHttpExecuter<HttpGet> {
	
	private static Logger log = LoggerFactory.getLogger(HttpGetExecuter.class);

	public HttpGetExecuter(final String url, final long sleepMillis) {
		super(url, sleepMillis);
	}
	@Override
	public HttpGetExecuter buildEntity() throws Exception {
		final URI uri = new URIBuilder(this.urlString).setParameters(params).build();
		if (log.isDebugEnabled()) {
			log.debug("Request :" + uri);
		}
		this.httpRequest = new HttpGet(uri);
		initHttpConfig();
		return this;
	}
}
