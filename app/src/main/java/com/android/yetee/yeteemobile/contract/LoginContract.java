package com.android.yetee.yeteemobile.contract;

import android.content.SharedPreferences;

import com.android.yetee.yeteemobile.viewHolder.LoginViewHolder;

public interface LoginContract {
    interface View extends MainContract.View {
        void login();
        void onClickRegisterButton();

        void setRegisterView();

        void setEventMapView();
        LoginViewHolder getLoginViewHolder();
    }

    interface Presenter {

        void setRegisterView();

        void login(SharedPreferences preferences);
    }
}
