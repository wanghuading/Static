package com.sz.rxjava2.httpclient;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RxjavaHttpClient {
    public static void main(String[] args) {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> observableEmitter) throws Exception {
                String url = "http://www.163.com";
                observableEmitter.onNext(url);
            }
        }).map(new Function<String, CloseableHttpResponse>() {
            @Override
            public CloseableHttpResponse apply(String url) throws Exception {
                CloseableHttpClient client = HttpClients.createDefault();
                HttpGet httpGet = new HttpGet(url);
                return client.execute(httpGet);
            }
        }).subscribe(new Consumer<CloseableHttpResponse>() {
            @Override
            public void accept(CloseableHttpResponse closeableHttpResponse) throws Exception {
                // 服务器返回码
                int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
                System.out.println("statusCode = " + statusCode);
                HttpEntity httpEntity = closeableHttpResponse.getEntity();
                // 服务器返回内容
                String respStr = null;
                if (httpEntity != null) {
                    respStr = EntityUtils.toString(httpEntity, "UTF-8");
                }
                System.out.println(respStr);
                // 释放资源
                EntityUtils.consume(httpEntity);
            }
        });
    }
}
