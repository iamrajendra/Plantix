package com.plantix.features.splash;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.plantix.BR;
import com.plantix.R;
import com.plantix.data.base.BaseFragment;
import com.plantix.databinding.SplashFragmentBinding;
import com.plantix.utills.NavigatorHelper;

public class SplashFragment extends BaseFragment<SplashFragmentBinding, SplashViewModel> implements SplashNavigator {
    private SplashViewModel mSplashViewModel = new SplashViewModel();

    @Override
    public int getBindingVariable() {
        return BR.splashmodel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.splash_fragment;
    }

    @Override
    public SplashViewModel getViewModel() {
        return mSplashViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashViewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        new Handler().postDelayed(() -> NavigatorHelper.getInstance().navigateTo(R.id.login), 2000);

    }

}

