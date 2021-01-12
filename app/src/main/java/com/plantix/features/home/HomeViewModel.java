package com.plantix.features.home;


import com.plantix.data.base.BaseViewModel;

import io.reactivex.disposables.CompositeDisposable;

public class HomeViewModel extends BaseViewModel<HomeNavigation> {
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }


}
