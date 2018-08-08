package com.android.yetee.yeteemobile.dataAccess.impl;

import com.android.yetee.yeteemobile.dataAccess.PointOfInterestDAO;
import com.android.yetee.yeteemobile.dataAccess.ServiceCalls;
import com.android.yetee.yeteemobile.model.PointOfInterest;
import com.android.yetee.yeteemobile.util.AsyncCallbackOneParam;
import com.android.yetee.yeteemobile.util.AsyncCallbackTwoParam;
import com.android.yetee.yeteemobile.util.ConnectionChecker;
import com.android.yetee.yeteemobile.util.ServiceResultState;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PointOfInterestDAOImpl implements PointOfInterestDAO {
    private ServiceCalls service;

    @Inject
    public PointOfInterestDAOImpl(ServiceCalls service) {
        this.service = service;
    }

    public void getAllPointsOfInterest(AsyncCallbackTwoParam<List<PointOfInterest>, ServiceResultState> callback) {
        Call<List<PointOfInterest>> call = service.getAllPointsOfInterest();
        call.enqueue(new Callback<List<PointOfInterest>>() {
            @Override
            public void onResponse(Call<List<PointOfInterest>> call, Response<List<PointOfInterest>> response) {
                callback.apply(response.body(), ServiceResultState.OK);
            }

            @Override
            public void onFailure(Call<List<PointOfInterest>> call, Throwable t) {
                ServiceResultState serviceResultState = ConnectionChecker.checkConnectivity(t);
                callback.apply(null, serviceResultState);
            }
        });
    }
}
