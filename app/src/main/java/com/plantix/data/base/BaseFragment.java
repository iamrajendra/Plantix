package com.plantix.data.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavOptions;


public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends Fragment {

    private static BaseFragment baseFragment;
    private T mViewDataBinding;
    private V mViewModel;
    private BaseActivity mActivity;
    private NavOptions.Builder navBuilder;

    public static BaseFragment getInstance() {

        return baseFragment;
    }

    public BaseActivity getmActivity() {
        return mActivity;
    }

    public abstract int getBindingVariable();

    @LayoutRes
    public abstract int getLayoutId();

    public abstract V getViewModel();

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public BaseFragment getBaseFragment() {

        return this;
    }


    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseFragment = this;
        mViewModel = getViewModel();
        navBuilder = new NavOptions.Builder();
        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return mViewDataBinding.getRoot();
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
    }


    public interface Callback {

    }
}
