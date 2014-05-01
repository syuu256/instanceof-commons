/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.util.http;

import java.net.URI;
import java.nio.charset.Charset;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HttpPostのラッパー
 * @author hic-miyakawa
 */
public class HttpPostExecuter extends AbstractHttpExecuter<HttpPost> {
	
	private static Logger log = LoggerFactory.getLogger(HttpPostExecuter.class);

	public HttpPostExecuter(final String url, final long sleepMillis) {
		super(url, sleepMillis);
	}
	@Override
	public HttpPostExecuter buildEntity() throws Exception {
		this.httpRequest = new HttpPost(new URI(this.urlString));
		initHttpConfig();
		final HttpEntity httpEntity = new UrlEncodedFormEntity(params, Consts.UTF_8);
		if (log.isDebugEnabled()) {
			final String body = new String(EntityUtils.toByteArray(httpEntity), Charset.forName("UTF-8"));
			log.debug("Request :" + urlString + "?" + body);
		}
		this.httpRequest.setEntity(httpEntity);
		return this;
	}
}
