package com.android.yetee.yeteemobile.business;

import com.android.yetee.yeteemobile.dataAccess.PointOfInterestDAO;
import com.android.yetee.yeteemobile.model.PointOfInterest;
import com.android.yetee.yeteemobile.util.AsyncCallbackOneParam;
import com.android.yetee.yeteemobile.util.AsyncCallbackTwoParam;
import com.android.yetee.yeteemobile.util.ServiceResultState;

import java.util.List;

import javax.inject.Inject;

public class PointOfInterestManager {

    private PointOfInterestDAO pointOfInterestDAO;

    @Inject
    public PointOfInterestManager(PointOfInterestDAO pointOfInterestDAO) {
        this.pointOfInterestDAO = pointOfInterestDAO;
    }

    public void getAllPointsOfInterest(AsyncCallbackTwoParam<List<PointOfInterest>, ServiceResultState> callback) {
        pointOfInterestDAO.getAllPointsOfInterest(callback);
    }

}
