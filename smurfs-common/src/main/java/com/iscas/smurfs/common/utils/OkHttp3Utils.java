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

    public static String httpGet(String url,String token){

        Interceptor mTokenInterceptor = new Interceptor() {
            @Override public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request authorised = originalRequest.newBuilder()
                        .header("Authorization", token)
                        .build();
                return chain.proceed(authorised);
            }
        };
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(mTokenInterceptor)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = null;
        String getResponse= null;
        try {
            response = client.newCall(request).execute();
            getResponse = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getResponse;
    }

    public static String httpPost(String url,String json,String token){
        Interceptor mTokenInterceptor = new Interceptor() {
            @Override public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request authorised = originalRequest.newBuilder()
                        .header("Authorization", token)
                        .build();
                return chain.proceed(authorised);
            }
        };
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(mTokenInterceptor)
                .build();
        String postResponse = null;
        try {
            RequestBody requestBody = RequestBody.create(type,json);
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();
            Response response = client.newCall(request).execute();
            postResponse = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postResponse;
    }
}
