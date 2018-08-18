package com.android.yetee.yeteemobile.dataAccess;

import com.android.yetee.yeteemobile.model.User;
import com.android.yetee.yeteemobile.util.AsyncCallbackOneParam;
import com.android.yetee.yeteemobile.util.AsyncCallbackTwoParam;
import com.android.yetee.yeteemobile.util.ServiceResultState;

import java.io.IOException;

public interface UserDAO {

    void login(String username, String password, AsyncCallbackOneParam<ServiceResultState> callback);

    void getToken(String username, String password, AsyncCallbackOneParam<String> callback) throws IOException;

    void register(User user, AsyncCallbackOneParam<ServiceResultState> callback);

    void getProfile(String username, AsyncCallbackTwoParam<User, ServiceResultState> callback);
}
