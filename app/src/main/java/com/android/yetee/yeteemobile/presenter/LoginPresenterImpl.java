package com.android.yetee.yeteemobile.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.yetee.yeteemobile.app.YeteeApplication;
import com.android.yetee.yeteemobile.business.UserManager;
import com.android.yetee.yeteemobile.constants.SharedPreferencesConstants;
import com.android.yetee.yeteemobile.contract.LoginContract;
import com.android.yetee.yeteemobile.util.AsyncCallbackOneParam;
import com.android.yetee.yeteemobile.util.NotificationUtil;
import com.android.yetee.yeteemobile.util.ServiceResultState;
import com.android.yetee.yeteemobile.viewHolder.LoginViewHolder;

import javax.inject.Inject;

public class LoginPresenterImpl implements LoginContract.Presenter {

    private LoginContract.View view;
    private UserManager userManager;
    private LoginViewHolder loginViewHolder;

    @Inject
    public LoginPresenterImpl(LoginContract.View view, UserManager userManager, LoginViewHolder loginViewHolder) {
        this.view = view;
        this.userManager = userManager;
        this.loginViewHolder = loginViewHolder;
    }

    @Override
    public void login(SharedPreferences preferences) {
        AsyncCallbackOneParam<String> callbackToken = (token) -> {
            preferences.edit()
                    .putString(SharedPreferencesConstants.USER_TOKEN, token)
                    .putBoolean(SharedPreferencesConstants.USER_IS_LOGGED, true)
                    .putString(SharedPreferencesConstants.USER_USERNAME, loginViewHolder.getLogin())
                    .apply();
            view.setEventMapView();
        };
        AsyncCallbackOneParam<ServiceResultState> callbackAction = (statusCode) -> {
            if (statusCode == ServiceResultState.OK) {
                userManager.getToken(loginViewHolder.getLogin(), loginViewHolder.getPassword(), callbackToken);
            }
            else {
                NotificationUtil.notifyLoginErrorDialog(view, statusCode);
            }
        };
        userManager.login(loginViewHolder.getLogin(), loginViewHolder.getPassword(), callbackAction);
    }
}
