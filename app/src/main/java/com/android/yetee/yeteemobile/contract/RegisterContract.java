package com.android.yetee.yeteemobile.contract;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.viewHolder.RegisterViewHolder;

import butterknife.OnClick;

public interface RegisterContract {

    interface View extends MainContract.View {
        RegisterViewHolder getRegisterViewHolder();
        void onClickRegisterButton();
        void setLoginView();
    }

    interface Presenter extends MainContract.Presenter {
        void register();
    }
}
