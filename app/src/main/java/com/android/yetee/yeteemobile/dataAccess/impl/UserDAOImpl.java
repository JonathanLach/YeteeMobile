package com.android.yetee.yeteemobile.dataAccess.impl;

import com.android.yetee.yeteemobile.dataAccess.ServiceCalls;
import com.android.yetee.yeteemobile.dataAccess.UserDAO;
import com.android.yetee.yeteemobile.model.User;
import com.android.yetee.yeteemobile.util.AsyncCallbackOneParam;
import com.android.yetee.yeteemobile.util.ConnectionChecker;
import com.android.yetee.yeteemobile.util.ServiceResultState;

import java.net.HttpURLConnection;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDAOImpl implements UserDAO {
    private ServiceCalls service;

    @Inject
    public UserDAOImpl(ServiceCalls service) {
        this.service = service;
    }

    @Override
    public void login(String username, String password, final AsyncCallbackOneParam<ServiceResultState> callback) {
        Call<User> call = service.getUserByNickname(username, password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                ServiceResultState serviceResultState = ServiceResultState.UNKNOWN_ERROR;
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    serviceResultState = ServiceResultState.OK;
                } else if (response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                    serviceResultState = ServiceResultState.NOT_FOUND;
                } else if (response.code() == HttpURLConnection.HTTP_CONFLICT) {
                    serviceResultState = ServiceResultState.PASSWORD_NOT_MATCH;
                } else if (response.code() == HttpURLConnection.HTTP_INTERNAL_ERROR) {
                    serviceResultState = ServiceResultState.SERVICE_INTERNAL_ERROR;
                }
                callback.apply(serviceResultState);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                ServiceResultState serviceResultState = ConnectionChecker.checkConnectivity(t);
                callback.apply(serviceResultState);
            }
        });
    }
}
