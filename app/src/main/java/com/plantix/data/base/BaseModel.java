package com.plantix.data.base;

import com.plantix.Application;
import com.plantix.data.remote.Api;
import com.plantix.data.remote.ApiFactory;
import com.plantix.data.remote.NetworkResponseCallbackWithComplete;

import java.io.IOException;
import java.io.Serializable;

import okhttp3.ResponseBody;
import retrofit2.Response;

// TODO: 27-03-2019 here S & T are Generics (Generify)
public abstract class BaseModel implements Serializable {

    public boolean doNetworkRequest(NetworkResponseCallbackWithComplete<?> networkResponseCallback) {
        if (Application.getInstance().checkInternet()) {
            if (networkResponseCallback != null)
                networkResponseCallback.onFailure(new Throwable("Internet is not available"));
            return false;
        } else return true;

    }


    public Api getApi() {
        return ApiFactory.getClientWithoutHeader().create(Api.class);
    }


    public String getResponseBody(Response<ResponseBody> response) throws IOException {
        if (response.body() != null) {
            return response.body().string();
        } else return "";
    }

}
