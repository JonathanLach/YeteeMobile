package com.android.yetee.yeteemobile.presenter;

import com.android.yetee.yeteemobile.business.PointOfInterestManager;
import com.android.yetee.yeteemobile.contract.PointsOfInterestContract;
import com.android.yetee.yeteemobile.model.PointOfInterest;
import com.android.yetee.yeteemobile.util.AsyncCallbackTwoParam;
import com.android.yetee.yeteemobile.util.NotificationUtil;
import com.android.yetee.yeteemobile.util.ServiceResultState;

import java.util.List;

import javax.inject.Inject;

public class PointsOfInterestPresenterImpl implements PointsOfInterestContract.Presenter {

    private PointsOfInterestContract.View view;
    private PointOfInterestManager pointOfInterestManager;

    @Inject
    public PointsOfInterestPresenterImpl(PointsOfInterestContract.View view, PointOfInterestManager pointOfInterestManager) {
        this.view = view;
        this.pointOfInterestManager = pointOfInterestManager;
    }

    @Override
    public void getPointsOfInterestFromEvent(Long eventId) {
        AsyncCallbackTwoParam<List<PointOfInterest>, ServiceResultState> callback = (poi, serviceResultState) -> {
            if(serviceResultState == ServiceResultState.OK) {
                for(PointOfInterest p : poi) {
                    view.addMarkerMap(p.getLatitude(), p.getLongitude(), p.getName());
                }
            }
            else {
                NotificationUtil.notifyCommonErrorDialog(view, serviceResultState);
            }
        };
        pointOfInterestManager.getPointsOfInterestFromEvent(eventId, callback);
    }
}
