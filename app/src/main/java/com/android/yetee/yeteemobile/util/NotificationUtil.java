package com.android.yetee.yeteemobile.util;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.contract.MainContract;

import java.util.List;

public class NotificationUtil {
    public static void notifyLoginErrorDialog(MainContract.View view, ServiceResultState serviceResultState) {
        switch (serviceResultState) {
            case NOT_FOUND:
                view.sendErrorDialog(view.getStringValue(R.string.error_login));
                break;
            case PASSWORD_NOT_MATCH:
                view.sendErrorDialog(view.getStringValue(R.string.error_password));
                break;
            default:
                notifyCommonErrorDialog(view, serviceResultState);
                break;
        }
    }

    public static void notifyRegisterErrorDialog(MainContract.View view, ServiceResultState serviceResultState, List<VerificationErrorCodes> verificationErrorCodes) {
        StringBuilder message = new StringBuilder();
        for(VerificationErrorCodes errorCode : verificationErrorCodes) {
            message.append(errorCode.toString()).append("\n");
        }
        view.sendErrorDialog(message.toString());
    }

    public static void notifyRegisterErrorDialog(MainContract.View view, ServiceResultState serviceResultState) {
        if(serviceResultState == ServiceResultState.LOGIN_ALREADY_EXISTS) {
            view.sendErrorDialog(view.getStringValue(R.string.error_login_exists));
        }
    }

    public static void notifyCommonErrorDialog(MainContract.View view, ServiceResultState serviceResultState) {
        switch (serviceResultState) {
            case CONNECTIVITY_ERROR:
                view.sendErrorDialog(view.getStringValue(R.string.error_connectivity));
                break;
            case SERVICE_INTERNAL_ERROR:
                view.sendErrorDialog(view.getStringValue(R.string.error_internal));
                break;
            default:
                view.sendErrorDialog(view.getStringValue(R.string.error_unexpected));
                break;
        }
    }
}