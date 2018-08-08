package com.android.yetee.yeteemobile.contract;

import com.google.android.gms.maps.GoogleMap;

public interface EventMapContract {

    interface View extends MainContract.View {
        void addMarkerMap(double latitude, double longitude, String title);
    }

    interface Presenter extends MainContract.Presenter {
        void getAllPointsOfInterest();
    }
}
