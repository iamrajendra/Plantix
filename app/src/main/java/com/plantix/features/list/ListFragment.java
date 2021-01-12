package com.plantix.features.list;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.plantix.BR;
import com.plantix.R;
import com.plantix.data.base.BaseFragment;
import com.plantix.data.database.dbpojo.Datum;
import com.plantix.databinding.ListFragmentBinding;
import com.plantix.features.list.adapter.ListAdapter;

import java.util.List;

public class ListFragment extends BaseFragment<ListFragmentBinding, ListViewModel> implements ListNavigator {
    private ListViewModel mListViewModel = new ListViewModel();
    private ListAdapter adapter = new ListAdapter();

    @Override
    public int getBindingVariable() {
        return BR.loginViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.list_fragment;
    }

    @Override
    public ListViewModel getViewModel() {
        return mListViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getViewModel().setNavigator(this);
        getViewModel().loadList();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getViewDataBinding().recyclerView.setAdapter(adapter);
        getViewModel().getList();
    }


    @Override
    public void response(List<Datum> datumList) {
        getBaseActivity().runOnUiThread(() -> {
            if (datumList != null && datumList.size() > 0) {
                adapter.setData(datumList);
                getViewDataBinding().recyclerView.setVisibility(View.VISIBLE);
                getViewDataBinding().noDataText.setVisibility(View.GONE);
            } else {
                getViewDataBinding().recyclerView.setVisibility(View.GONE);
                getViewDataBinding().noDataText.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getViewModel().getmCompositeDisposable().dispose();
    }
}

