package com.plantix.data.base;


import com.plantix.BaseObservableViewModel;

public class BaseViewModel<N> extends BaseObservableViewModel {
    private N mNavigator;

    public BaseViewModel() {
    }

    public N getNavigator() {
        return mNavigator;
    }

    public void setNavigator(N mNavigator) {
        this.mNavigator = mNavigator;
    }

}
