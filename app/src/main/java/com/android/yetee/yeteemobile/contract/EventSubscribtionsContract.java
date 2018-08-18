package com.android.yetee.yeteemobile.contract;

import android.content.Context;

import com.android.yetee.yeteemobile.viewHolder.EventSubscribtionsViewHolder;

public interface EventSubscribtionsContract {
    interface View extends MainContract.View {
        EventSubscribtionsViewHolder getViewHolder();
    }

    interface Presenter extends MainContract.Presenter {
        void getSubscribtions();
    }
}
