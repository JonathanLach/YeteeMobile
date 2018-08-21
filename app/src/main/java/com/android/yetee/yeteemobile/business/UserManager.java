package com.android.yetee.yeteemobile.business;

import com.android.yetee.yeteemobile.dataAccess.UserDAO;
import com.android.yetee.yeteemobile.model.User;
import com.android.yetee.yeteemobile.util.AsyncCallbackOneParam;
import com.android.yetee.yeteemobile.util.AsyncCallbackTwoParam;
import com.android.yetee.yeteemobile.util.ServiceResultState;

import java.io.IOException;

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

    public void getToken(String username, String password, AsyncCallbackOneParam<String> callback) throws IOException {
        userDAO.getToken(username, password, callback);
    }

    public void register(User user, AsyncCallbackOneParam<ServiceResultState> callback) {
        userDAO.register(user, callback);
    }

    public void getProfile(String username, AsyncCallbackTwoParam<User, ServiceResultState> callback) {
        userDAO.getProfile(username, callback);
    }
}
