package com.plantix.data.remote;

import java.util.List;

public interface NetworkResponseCallback<T extends Object> {
    void onResponse(List<T> list);

    void onResponse(T object);

    void onFailure(Throwable t);

//    void onComplete();


}
