package com.plantix;


import android.content.Context;
import android.net.ConnectivityManager;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.LifecycleObserver;

public class Application extends android.app.Application implements LifecycleObserver {
    private static Application application;


    public static Application getInstance() {

        return application;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    public boolean checkInternet() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isConnected();

    }


}
