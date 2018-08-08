package com.android.yetee.yeteemobile.dataAccess;

import com.android.yetee.yeteemobile.model.PointOfInterest;
import com.android.yetee.yeteemobile.util.AsyncCallbackOneParam;
import com.android.yetee.yeteemobile.util.AsyncCallbackTwoParam;
import com.android.yetee.yeteemobile.util.ServiceResultState;

import java.util.List;

public interface PointOfInterestDAO {
    void getAllPointsOfInterest(AsyncCallbackTwoParam<List<PointOfInterest>, ServiceResultState> callback);
}
