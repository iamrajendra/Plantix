package com.plantix.data.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel<?>> extends AppCompatActivity {
    private V mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDataBinding();

    }

    private void performDataBinding() {
        T mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
    }


    public void onFragmentAttached() {

    }

    @LayoutRes
    public abstract int getLayoutId();

    public abstract V getViewModel();

    public abstract int getBindingVariable();


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
