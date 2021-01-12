package com.plantix.data.remote;


import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by Irshad
 */

public interface Api {

    String LIVE_URL = "https://reqres.in"; // live server

    @GET("/api/users?page=1")
    Observable<Response<ResponseBody>> getList();
}
