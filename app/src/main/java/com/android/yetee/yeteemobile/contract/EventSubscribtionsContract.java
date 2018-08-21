package com.android.yetee.yeteemobile.contract;

import com.android.yetee.yeteemobile.viewHolder.EventSubscribtionsViewHolder;

public interface EventSubscribtionsContract {
    interface View extends MainContract.View {
        EventSubscribtionsViewHolder getViewHolder();
    }

    interface Presenter {
        void getSubscribtions();
    }
}
