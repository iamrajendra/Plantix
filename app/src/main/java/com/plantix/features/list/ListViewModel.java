package com.plantix.features.list;


import com.plantix.data.base.BaseViewModel;
import com.plantix.data.database.RoomDB;
import com.plantix.data.database.dbpojo.Datum;
import com.plantix.data.model.ListModel;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ListViewModel extends BaseViewModel<ListNavigator> {
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private ListQueryMapper queryMapper = new ListQueryMapper();

    public ListQueryMapper getQueryMapper() {
        return queryMapper;
    }

    public void loadList() {
        new Thread(() -> {
            if (!getQueryMapper().isDataAvailable())
                new ListModel().doNetworkRequest(null);
        }).start();
    }

    public void getList() {
        Disposable disposable = RoomDB.getDefaultInstance().datumTableDao().getAllDataFlowable(getQueryMapper().getAllDataQuery()).toObservable().subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribeWith(new DisposableObserver<List<Datum>>() {
            @Override
            public void onNext(List<Datum> datumList) {
                getNavigator().response(datumList);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        mCompositeDisposable.add(disposable);
    }

    public CompositeDisposable getmCompositeDisposable() {
        return mCompositeDisposable;
    }
}
