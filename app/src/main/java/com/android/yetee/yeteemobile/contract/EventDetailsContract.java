package com.android.yetee.yeteemobile.contract;

import android.content.Context;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.viewHolder.EventDetailsViewHolder;

import butterknife.OnClick;

public interface EventDetailsContract {
    interface View extends MainContract.View {
        void updateDetails(Long id);

        void subscribeToEvent();

        void onClickPointsOfInterestButton();

        void setPointsOfInterestView();

        EventDetailsViewHolder getViewHolder();
    }

    interface Presenter {
        void getEventDetails(Long id);

        void subscribeToEvent(Long id, Context context);

        void setPointsOfInterestView();
    }
}
