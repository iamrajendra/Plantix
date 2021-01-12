package com.plantix.data.remote;

public interface NetworkResponseCallbackWithComplete<T extends Object> extends NetworkResponseCallback<T> {
    void onComplete();
}
