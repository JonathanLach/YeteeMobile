package com.android.yetee.yeteemobile.dataAccess;

import com.android.yetee.yeteemobile.util.AsyncCallbackOneParam;
import com.android.yetee.yeteemobile.util.ServiceResultState;

public interface UserDAO {

    void login(String username, String password, AsyncCallbackOneParam<ServiceResultState> callback);
}

