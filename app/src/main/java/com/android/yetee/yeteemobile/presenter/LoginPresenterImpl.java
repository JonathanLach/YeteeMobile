package com.android.yetee.yeteemobile.presenter;

import com.android.yetee.yeteemobile.business.UserManager;
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
    public void login() {
        AsyncCallbackOneParam<ServiceResultState> callbackAction = (statusCode) -> {
            if (statusCode == ServiceResultState.OK) {
                view.setEventMapView();
            }
            else {
                NotificationUtil.notifyLoginErrorDialog(view, statusCode);
            }
        };
        userManager.login(loginViewHolder.getLogin(), loginViewHolder.getPassword(), callbackAction);
    }
}
