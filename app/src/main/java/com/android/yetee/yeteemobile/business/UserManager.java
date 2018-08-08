package com.android.yetee.yeteemobile.business;

import com.android.yetee.yeteemobile.dataAccess.UserDAO;
import com.android.yetee.yeteemobile.util.AsyncCallbackOneParam;
import com.android.yetee.yeteemobile.util.ServiceResultState;

import javax.inject.Inject;

public class UserManager {

    private UserDAO userDAO;

    @Inject
    public UserManager(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void login(String username, String password, AsyncCallbackOneParam<ServiceResultState> callback) {
        userDAO.login(username, password, callback);
    }
}
