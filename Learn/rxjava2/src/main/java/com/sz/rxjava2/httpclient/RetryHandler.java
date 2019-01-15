package com.sz.rxjava2.httpclient;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.protocol.HttpContext;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

public class RetryHandler implements HttpRequestRetryHandler {
    @Override
    public boolean retryRequest(IOException e, int executionCount, HttpContext httpContext) {
        // 如果已经重试3次，就放弃
        if (executionCount >= 3) {
            return false;
        }
        // 如果服务器丢弃了连接那么就重试
        if (e instanceof NoHttpResponseException) {
            return true;
        }
        // 不要重试SSL握手异常
        if (e instanceof SSLHandshakeException) {
            return false;
        }
        // 超时
        if (e instanceof InterruptedIOException) {
            return true;
        }
        if (e instanceof UnknownHostException) {
            return false;
        }
        // 连接被拒绝
        if (e instanceof ConnectTimeoutException) {
            return false;
        }
        // ssl握手异常
        if (e instanceof SSLException) {
            return false;
        }
        HttpClientContext clientContext = HttpClientContext.adapt(httpContext);
        HttpRequest request = clientContext.getRequest();
        // 如果请求是幂等的，就再次尝试
        if (!(request instanceof HttpEntityEnclosingRequest)) {
            return true;
        }
        return false;
    }
}
