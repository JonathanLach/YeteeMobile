package com.android.yetee.yeteemobile.contract;

import com.android.yetee.yeteemobile.viewHolder.EventsListViewHolder;

public interface EventsListContract {

    interface View extends MainContract.View {
        void setDetailsView(Long id);

        EventsListViewHolder getViewHolder();
    }

    interface Presenter {
        void setDetailsView(int position);

        void getAllEvents();
    }
}
