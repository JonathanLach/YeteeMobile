package com.android.yetee.yeteemobile.contract;

public interface MainContract {

    interface View {
        void sendErrorDialog(String text);
        void sendSuccessDialog(String text);
        String getStringValue(int refId);
    }

    interface Presenter {
        void setEventsListView();
        void setEventsMapView();
        void setProfileView();
        void setSubscribtionView();
    }

    interface ViewHandler extends View {
        void setEventsListView();
        void setEventsMapView();
        void setEventSubscribtionView();
        void setProfileView();
    }
}
