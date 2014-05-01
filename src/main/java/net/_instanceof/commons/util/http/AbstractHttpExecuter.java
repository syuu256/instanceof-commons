/*
 * Copyright(C) 2014 syuu256\gmail.com. All Rights Reserved.
 */
package net._instanceof.commons.util.http;

import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;

/**
 * http.clientのラッパー
 */
public abstract class AbstractHttpExecuter<T extends HttpRequestBase> implements AutoCloseable {

	private static Logger log = LoggerFactory.getLogger(AbstractHttpExecuter.class);

	/** タイムアウト (10秒)*/
	private static final int TIMEOUT = 1000 * 10;

	private static final long WARN_RESPONSE_TIME = 3000L;
	
	protected final List<NameValuePair> params = Lists.newArrayList();

	protected T httpRequest;

	protected HttpResponse httpResponse;

	protected String urlString = "";

	protected long sleepMillis = 10L;

	protected int httpStatus;

	protected AbstractHttpExecuter(final String urlString, final long sleepMillis) {
		this.urlString = urlString;
		this.sleepMillis = sleepMillis;
	}

	protected final void initHttpConfig() {
	    final RequestConfig requestConfig = RequestConfig.custom()
	    		.setConnectionRequestTimeout(TIMEOUT)
	    		.setConnectTimeout(TIMEOUT)
	    		.setSocketTimeout(TIMEOUT)
	    		.build();
	    httpRequest.setConfig(requestConfig);
	}
	public final AbstractHttpExecuter<T> add(final String name, final String value) {
		params.add(new BasicNameValuePair(name, value));
		return this;
	}
	public final AbstractHttpExecuter<T> execute(final HttpClient httpClient) throws Exception {

		final Stopwatch stopwatch = Stopwatch.createStarted();
		httpResponse = httpClient.execute(httpRequest);
		final long time = stopwatch.elapsed(TimeUnit.MILLISECONDS);

		// 3秒以上は警告を出力する　パラメータはスレッド名から解析できる
		if (time > WARN_RESPONSE_TIME) {
			if (log.isWarnEnabled()) {
				log.warn("[" + httpRequest.getMethod() + "][" + urlString + "][" + time + "]");
			}
		}

		httpStatus = httpResponse.getStatusLine().getStatusCode();
		// 200以外はエラー固定
		if (isStatusError(httpStatus)) {
			final String body = getBody();
			final String message = "urlString:" + urlString + "/params:" + params + "/http_status:" + httpStatus + "[" + body + "]";
			if (log.isErrorEnabled()) {
				log.error("HTTPERROR:" + message);
			}
			throw new ClientProtocolException(message);
		}
		return this;
	}

	public String getBody() throws Exception {
		final String body = EntityUtils.toString(httpResponse.getEntity(), Charset.forName("Windows-31J"));
		if (log.isDebugEnabled()) {
			log.debug("Response:httpStatus=[" + httpStatus + "]body=[" + body + "]");
		}
		return body;
	}

	public abstract AbstractHttpExecuter<T> buildEntity() throws Exception;

	/**
	 * use Override
	 * @param httpStatus
	 * @return true = error
	 */
	public boolean isStatusError(final int httpStatus) {
		// 200-299まで正常
		return !(HttpStatus.SC_MULTIPLE_CHOICES > httpStatus && httpStatus >= HttpStatus.SC_OK);
	}

	/**
	 *  AutoCloseable
	 */
	@Override
	public void close() throws Exception {
		if (httpRequest != null && !httpRequest.isAborted()) httpRequest.abort();
		httpRequest = null;
		params.clear();
	}
}
