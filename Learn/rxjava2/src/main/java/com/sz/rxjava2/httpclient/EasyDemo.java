package com.sz.rxjava2.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class EasyDemo {
    public static void main(String[] args) {
        HttpEntity httpEntity = null;
        try {
            String url = "http://www.163.com";
            // 使用默认配置HTTPClient的实例
            CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);
            // 服务器返回码
            int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
            System.out.println("statusCode = " + statusCode);
            // 服务器相应成功
            if (statusCode == 200) {
                // 服务器返回内容
                String respStr = null;
                httpEntity = closeableHttpResponse.getEntity();
                if (httpEntity != null) {
                    respStr = EntityUtils.toString(httpEntity, "UTF-8");
                    System.out.println(respStr);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (httpEntity != null) {
                // 释放资源
                try {
                    EntityUtils.consume(httpEntity);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
