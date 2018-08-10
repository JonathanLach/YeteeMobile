package com.android.yetee.yeteemobile.contract;

import com.android.yetee.yeteemobile.viewHolder.EventDetailsViewHolder;

public interface EventDetailsContract {
    interface View extends MainContract.View {
        EventDetailsViewHolder getViewHolder();
    }

    interface Presenter extends MainContract.Presenter {
        void getEventDetails(Long id);
    }
}
