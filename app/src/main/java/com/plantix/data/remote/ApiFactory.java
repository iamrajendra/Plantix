package com.plantix.data.remote;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Irshad
 */

public class ApiFactory {

    public static Retrofit getClientWithoutHeader() {

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        httpClientBuilder.addInterceptor(chain -> {

            Request original = chain.request();

            Request.Builder requestBuilder = original.newBuilder();

            requestBuilder.addHeader("Content-Type", "application/json");
            requestBuilder.addHeader("Accept", "application/json");
            requestBuilder.addHeader("Connection", "keep-alive");

            Request request = requestBuilder.build();

            return chain.proceed(request);
        });

        httpClientBuilder.connectTimeout(5, TimeUnit.MINUTES);
        httpClientBuilder.readTimeout(5, TimeUnit.MINUTES);
        httpClientBuilder.writeTimeout(5, TimeUnit.MINUTES);


        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        httpClientBuilder.addInterceptor(loggingInterceptor);
        return new Retrofit.Builder()
                .baseUrl(getUrl())
                .client(httpClientBuilder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static String getUrl() {
        return Api.LIVE_URL;

    }

}
