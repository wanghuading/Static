package com.sz.rxjava2.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class TestHttpClientWithPool {
    /**
     * 全局连接池对象
     */
    private static final PoolingHttpClientConnectionManager connManager =
            new PoolingHttpClientConnectionManager();

    /**
     * 静态代码块配置连接池信息
     */
    static {
        // 设置最大连接数
        connManager.setMaxTotal(200);
        // 设置每个连接的路由数
        connManager.setDefaultMaxPerRoute(20);
    }

    /**
     * 获取Http客户端连接对象
     * @param timeOut 超时时间
     * @return Http客户端连接对象
     */
    public static CloseableHttpClient getHttpClient(int timeOut) {
        // 创建Http请求配置参数
        RequestConfig requestConfig = RequestConfig.custom()
                // 获取连接超时时间
                .setConnectionRequestTimeout(timeOut)
                // 请求超时时间
                .setConnectTimeout(timeOut)
                // 响应超时时间
                .setSocketTimeout(timeOut)
                .build();
        // 创建HttpClientConnectTimeoutException
        return HttpClients.custom()
                // 把请求相关的超时信息设置设置到客户端
                .setDefaultRequestConfig(requestConfig)
                // 把请求重试设置连接客户端
                .setRetryHandler(new RetryHandler())
                // 配置连接池管理对象
                .setConnectionManager(connManager)
                .build();
    }

    public static String httpGet(String url, int timeOut) {
        String msg = null;
        // 获取客户端对象
        CloseableHttpClient httpClient = getHttpClient(timeOut);
        // 创建Get请求对象
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpClient.execute(httpGet);
            // 获取响应体
            HttpEntity httpEntity = response.getEntity();
            // 获取响应信息
            msg = EntityUtils.toString(httpEntity, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return msg;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 202; i++) {
            System.out.println(httpGet("http://www.163.com", 500));
        }
    }
}
