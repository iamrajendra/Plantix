package com.plantix.features.home;

import android.os.Bundle;
import android.view.WindowManager;

import com.plantix.BR;
import com.plantix.R;
import com.plantix.data.base.BaseActivity;
import com.plantix.databinding.ActivityHomeBinding;
import com.plantix.utills.NavigatorHelper;


public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeViewModel> implements HomeNavigation {
    public static HomeActivity Instance;
    private HomeViewModel homeViewModel = new HomeViewModel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Instance = this;
        NavigatorHelper.getInstance().init(this, R.id.home_navigator_host);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        homeViewModel.setNavigator(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getViewModel().getCompositeDisposable().dispose();

    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public HomeViewModel getViewModel() {
        return homeViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.homeModel;
    }


    @Override
    public void onBackPressed() {
        NavigatorHelper.getInstance().onBackPressed();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

}
