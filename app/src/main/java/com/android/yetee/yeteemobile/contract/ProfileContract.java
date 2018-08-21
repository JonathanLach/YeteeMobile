package com.android.yetee.yeteemobile.contract;

import android.content.Context;

import com.android.yetee.yeteemobile.viewHolder.ProfileViewHolder;

public interface ProfileContract {

    interface View extends MainContract.View {

        ProfileViewHolder getViewHolder();
    }

    interface Presenter {
        void getProfile(Context context);
    }
}
