package com.android.yetee.yeteemobile.util;

import android.util.Log;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

public class ConnectionChecker {
    public final static String CONNECTION_TAG_LOG = "Connection Log";

    public static ServiceResultState checkConnectivity(Throwable t) {
        Log.e(CONNECTION_TAG_LOG,t.getMessage(),t);
        ServiceResultState serviceResultState = ServiceResultState.UNKNOWN_ERROR;
        if (t instanceof IOException) {
            serviceResultState = ServiceResultState.CONNECTIVITY_ERROR;
        }
        else if (t instanceof SocketTimeoutException || t instanceof TimeoutException || t instanceof ConnectException) {
            serviceResultState = ServiceResultState.CONNECTION_TIMEOUT;
        }
        return serviceResultState;
    }
}