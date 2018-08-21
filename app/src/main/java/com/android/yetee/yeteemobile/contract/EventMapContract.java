package com.android.yetee.yeteemobile.contract;

public interface EventMapContract {

    interface View extends MainContract.View {
        void addMarkerMap(double latitude, double longitude, String title);
    }

    interface Presenter {
        void getEventLocations();
    }
}
