package com.android.yetee.yeteemobile.contract;

import android.content.Context;

import com.android.yetee.yeteemobile.viewHolder.EventDetailsViewHolder;

public interface EventDetailsContract {
    interface View extends MainContract.View {
        void updateDetails(Long id);

        void subscribeToEvent();

        void setPointsOfInterest();

        EventDetailsViewHolder getViewHolder();
    }

    interface Presenter {
        void getEventDetails(Long id);

        void subscribeToEvent(Long id, Context context);
    }
}
