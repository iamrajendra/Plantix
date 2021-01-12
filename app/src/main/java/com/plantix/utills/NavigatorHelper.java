package com.plantix.utills;

import android.app.Activity;

import androidx.annotation.IdRes;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class NavigatorHelper {
    private static NavigatorHelper navigatorHelper = null;
    private NavController controller;

    public static NavigatorHelper getInstance() {
        if (navigatorHelper == null) {
            navigatorHelper = new NavigatorHelper();
        }
        return navigatorHelper;
    }

    public void navigateTo(@IdRes int destinationResId) {
        try {
            getController().navigate(destinationResId);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public NavController getController() {
        return controller;
    }

    public void setController(NavController controller) {
        this.controller = controller;
    }

    public void onBackPressed() {
        controller.popBackStack();
    }

    public void init(Activity activity, @IdRes int hostId) {
        setController(Navigation.findNavController(activity, hostId));
    }


}
