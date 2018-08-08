package com.android.yetee.yeteemobile.util;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.contract.MainContract;

public class NotificationUtil {
    public static void notifyLoginErrorDialog(MainContract.View view, ServiceResultState serviceResultState) {
        if (serviceResultState == ServiceResultState.NOT_FOUND) {
            view.sendErrorDialog(view.getStringValue(R.string.error_login));
        } else if (serviceResultState == ServiceResultState.PASSWORD_NOT_MATCH) {
            view.sendErrorDialog(view.getStringValue(R.string.error_password));
        } else {
            notifyCommonErrorDialog(view, serviceResultState);
        }
    }

    public static void notifyRegisterErrorDialog(MainContract.View view, ServiceResultState serviceResultState) {
        if(serviceResultState == ServiceResultState.LOGIN_ALREADY_EXISTS) {
            view.sendErrorDialog(view.getStringValue(R.string.error_login_exists));
        }
    }

    public static void notifyCommonErrorDialog(MainContract.View view, ServiceResultState serviceResultState) {
        if (serviceResultState == ServiceResultState.CONNECTIVITY_ERROR) {
            view.sendErrorDialog(view.getStringValue(R.string.error_connectivity));
        } else if (serviceResultState == ServiceResultState.SERVICE_INTERNAL_ERROR) {
            view.sendErrorDialog(view.getStringValue(R.string.error_internal));
        } else {
            view.sendErrorDialog(view.getStringValue(R.string.error_unexpected));
        }
    }
}