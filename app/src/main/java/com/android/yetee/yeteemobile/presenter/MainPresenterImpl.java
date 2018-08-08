package com.android.yetee.yeteemobile.presenter;

import com.android.yetee.yeteemobile.activity.MainActivity;
import com.android.yetee.yeteemobile.contract.MainContract;

import javax.inject.Inject;

public class MainPresenterImpl implements MainContract.Presenter {

    private MainContract.View view;

    @Inject
    public MainPresenterImpl(MainContract.View view) {
        this.view = view;
    }



}
