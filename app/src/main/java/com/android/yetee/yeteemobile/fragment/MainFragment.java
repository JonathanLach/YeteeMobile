package com.android.yetee.yeteemobile.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.contract.MainContract;
import com.android.yetee.yeteemobile.presenter.MainPresenterImpl;

import javax.inject.Inject;

import dagger.android.DaggerFragment;
import dagger.android.support.DaggerAppCompatActivity;

public class MainFragment extends DaggerFragment implements MainContract.View {

    private static String ERROR_DEBUG_TAG = "DEBUG INFO";

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
