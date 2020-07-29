package com.kedaxunfei.utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@Component
@Slf4j
public class HttpPostUtils {
    private static CloseableHttpClient httpClient = null;
    private static CloseableHttpResponse httpResponse = null;
    private static HttpPost httpPost = null;
    private static RequestConfig requestConfig = null;
    private static HttpEntity responseEntity = null;
    private static Object object = null;


    public <T> T getResponse(Class<T> entityClass, String param, String url) {
       T t = null;
        try {
            httpClient = HttpClientBuilder.create().build();
            httpPost = new HttpPost(url);
            requestConfig = RequestConfig.custom()
                    // 设置连接超时时间(单位毫秒)
                    .setConnectTimeout(5000)
                    // 设置请求超时时间(单位毫秒)
                    .setConnectionRequestTimeout(5000)
                    // socket读写超时时间(单位毫秒)
                    .setSocketTimeout(5000)
                    // 设置是否允许重定向(默认为true)
                    .setRedirectsEnabled(true).build();
            //请求设置配置给这个get方法
            httpPost.setConfig(requestConfig);
            // 构建消息实体
            StringEntity entity = new StringEntity(param, Charset.forName("UTF-8"));
            entity.setContentEncoding("UTF-8");
            // 发送Json格式的数据请求
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            httpResponse = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            responseEntity = httpResponse.getEntity();
            //转换为json字符串
            String responseToS = EntityUtils.toString(responseEntity);
            //把字符串转换为bean
            t = JSONObject.parseObject(responseToS, entityClass);
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                log.info("获取远程服务失败 响应状态码=" + httpResponse.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            log.info("出现异常");
            e.printStackTrace();
        } finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
                if (httpResponse != null) {
                    httpResponse.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return t;
    }

}
