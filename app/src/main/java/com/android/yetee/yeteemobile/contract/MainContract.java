package com.android.yetee.yeteemobile.contract;

public interface MainContract {

    interface View {
        void sendErrorDialog(String text);
        void sendSuccessDialog(String text);
        String getStringValue(int refId);
    }

    interface Presenter {

    }
}
