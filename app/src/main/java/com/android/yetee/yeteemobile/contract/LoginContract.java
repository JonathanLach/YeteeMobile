package com.android.yetee.yeteemobile.contract;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.viewHolder.LoginViewHolder;

import butterknife.OnClick;

public interface LoginContract {
    interface View extends MainContract.View {
        void login();

        void setEventMapView();

        LoginViewHolder getLoginViewHolder();
    }

    interface Presenter extends MainContract.Presenter {

        void login();
    }
}
