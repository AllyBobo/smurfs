package com.iscas.smurfs.common.utils;

import okhttp3.*;

import java.io.IOException;

/**
 * description:
 *
 * @author 123
 * @date 2018/9/6
 */
public class OkHttp3Utils {
    public static final MediaType type = MediaType.parse("application/json;charset=utf-8");
    public static final OkHttpClient httpClient = new OkHttpClient();

    /**
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String httpGet(String url){
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = null;
        String getResponse= null;
        try {
            response = httpClient.newCall(request).execute();
            getResponse = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getResponse;
    }

    /**
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public static String httpPost(String url,String json){
        String postResponse = null;
        try {
            RequestBody requestBody = RequestBody.create(type,json);
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();
            Response response = httpClient.newCall(request).execute();
            postResponse = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postResponse;
    }
}
