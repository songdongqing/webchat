package com.example.webchat.util;

import com.squareup.okhttp.*;

public class JsonPost {

    /**
     * 工具类不允许有 public 或 default 构造方法
     */
    private JsonPost(){}

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    static OkHttpClient client = new OkHttpClient();

    /**
     * 发送Post请求
     * @param url 请求地址
     * @param json json格式字符串
     * @return
     * @throws Exception
     */
    public static String jsonPost(String url, String json) throws Exception {
        Request request = null;
        if(json != null){
            RequestBody body = RequestBody.create(JSON, json);
            request = new Request.Builder().url(url).post(body).build();
        }else{
            request = new Request.Builder().url(url).build();
        }
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
