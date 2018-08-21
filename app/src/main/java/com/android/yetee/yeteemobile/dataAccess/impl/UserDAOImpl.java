package com.android.yetee.yeteemobile.dataAccess.impl;

import android.util.Log;

import com.android.yetee.yeteemobile.dataAccess.ServiceCalls;
import com.android.yetee.yeteemobile.dataAccess.UserDAO;
import com.android.yetee.yeteemobile.model.Token;
import com.android.yetee.yeteemobile.model.TokenRequest;
import com.android.yetee.yeteemobile.model.User;
import com.android.yetee.yeteemobile.util.AsyncCallbackOneParam;
import com.android.yetee.yeteemobile.util.AsyncCallbackTwoParam;
import com.android.yetee.yeteemobile.util.ConnectionChecker;
import com.android.yetee.yeteemobile.util.ServiceResultState;

import java.io.IOException;
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
        Call<User> call = service.login(username, password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                ServiceResultState serviceResultState = ServiceResultState.UNKNOWN_ERROR;
                switch (response.code()) {
                    case HttpURLConnection.HTTP_OK:
                        serviceResultState = ServiceResultState.OK;
                        break;
                    case HttpURLConnection.HTTP_NOT_FOUND:
                        serviceResultState = ServiceResultState.NOT_FOUND;
                        break;
                    case HttpURLConnection.HTTP_CONFLICT:
                        serviceResultState = ServiceResultState.PASSWORD_NOT_MATCH;
                        break;
                    case HttpURLConnection.HTTP_INTERNAL_ERROR:
                        serviceResultState = ServiceResultState.SERVICE_INTERNAL_ERROR;
                        break;
                }
                try {
                    callback.apply(serviceResultState);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                ServiceResultState serviceResultState = ConnectionChecker.checkConnectivity(t);
                try {
                    callback.apply(serviceResultState);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void getToken(String username, String password, AsyncCallbackOneParam<String> callback) throws IOException {
        Call<Token> call = service.getToken(new TokenRequest(username, password));
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                try {
                    callback.apply(response.body().getTokenValue());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Log.e("Error with token", "Service is down");
            }
        });
    }

    @Override
    public void register(User user, AsyncCallbackOneParam<ServiceResultState> callback) {
        Call<Void> call = service.register(user);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                ServiceResultState serviceResultState = ServiceResultState.UNKNOWN_ERROR;
                if (response.code() == HttpURLConnection.HTTP_CREATED) {
                    serviceResultState = ServiceResultState.OK;
                }
                try {
                    callback.apply(serviceResultState);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                try {
                    callback.apply(ConnectionChecker.checkConnectivity(t));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void getProfile(String username, AsyncCallbackTwoParam<User, ServiceResultState> callback) {
        Call<User> call = service.getUserByUsername(username);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.code() == HttpURLConnection.HTTP_OK) {
                    callback.apply(response.body(), ServiceResultState.OK);
                }
                else {
                    if(response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                        callback.apply(null, ServiceResultState.NOT_FOUND);
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.apply(null, ConnectionChecker.checkConnectivity(t));
            }
        });
    }

}
