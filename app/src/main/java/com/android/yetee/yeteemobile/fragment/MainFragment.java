package com.android.yetee.yeteemobile.fragment;

import android.util.Log;
import android.widget.Toast;

import com.android.yetee.yeteemobile.contract.MainContract;

import dagger.android.DaggerFragment;

public class MainFragment extends DaggerFragment implements MainContract.View {

    private String ERROR_DEBUG_TAG = "DEBUG INFO";

    @Override
    public void sendErrorDialog(String text) {
        Log.d(ERROR_DEBUG_TAG, text);
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sendSuccessDialog(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getStringValue(int refId) {
        return getString(refId);
    }
}
