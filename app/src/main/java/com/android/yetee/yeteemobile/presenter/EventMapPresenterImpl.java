package com.android.yetee.yeteemobile.presenter;

import com.android.yetee.yeteemobile.business.PointOfInterestManager;
import com.android.yetee.yeteemobile.contract.EventMapContract;
import com.android.yetee.yeteemobile.model.PointOfInterest;
import com.android.yetee.yeteemobile.util.AsyncCallbackOneParam;
import com.android.yetee.yeteemobile.util.AsyncCallbackTwoParam;
import com.android.yetee.yeteemobile.util.NotificationUtil;
import com.android.yetee.yeteemobile.util.ServiceResultState;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import javax.inject.Inject;

public class EventMapPresenterImpl implements EventMapContract.Presenter {
    private EventMapContract.View view;

    private PointOfInterestManager pointOfInterestManager;

    @Inject
    public EventMapPresenterImpl(EventMapContract.View view, PointOfInterestManager pointOfInterestManager) {
        this.view = view;
        this.pointOfInterestManager = pointOfInterestManager;
    }

    public void getAllPointsOfInterest() {
        AsyncCallbackTwoParam<List<PointOfInterest>, ServiceResultState> callback = (pointsOfInterest, serviceResultState) -> {
            if(serviceResultState != ServiceResultState.OK) {
                NotificationUtil.notifyCommonErrorDialog(view, serviceResultState);
            }
            else {
                for(PointOfInterest poi : pointsOfInterest) {
                    view.addMarkerMap(poi.getLatitude(), poi.getLongitude(), poi.getName());
                }
            }
        };
        pointOfInterestManager.getAllPointsOfInterest(callback);
    }
}
