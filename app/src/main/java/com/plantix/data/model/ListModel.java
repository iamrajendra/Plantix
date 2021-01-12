package com.plantix.data.model;

import com.google.gson.GsonBuilder;
import com.plantix.data.base.BaseModel;
import com.plantix.data.database.RoomDB;
import com.plantix.data.local.pojo.Users;
import com.plantix.data.remote.NetworkResponseCallbackWithComplete;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class ListModel extends BaseModel {


    public ListModel() {
    }

    @Override
    public boolean doNetworkRequest(NetworkResponseCallbackWithComplete<?> networkResponseCallback) {
        if (!super.doNetworkRequest(networkResponseCallback))
            return false;
        getApi().getList().subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new Observer<Response<ResponseBody>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response<ResponseBody> responseBodyResponse) {
                try {
                    String responseBody = getResponseBody(responseBodyResponse);
                    if (responseBody != null && responseBody.length() > 0) {
                        Users users = new GsonBuilder().create().fromJson(responseBody, Users.class);
                        if (users != null && users.getData() != null && users.getData().size() > 0) {
                            RoomDB.getDefaultInstance().datumTableDao().insert(users.getData());
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {

            }
        });
        return false;
    }

}

