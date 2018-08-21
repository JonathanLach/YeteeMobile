package com.android.yetee.yeteemobile.presenter;

import com.android.yetee.yeteemobile.contract.MainContract;

import javax.inject.Inject;

public class MainPresenterImpl implements MainContract.Presenter {

    MainContract.ViewHandler view;

    public MainPresenterImpl(MainContract.ViewHandler view) {
        this.view = view;
    }

    @Override
    public void setEventsListView() {
        view.setEventsListView();
    }

    @Override
    public void setEventsMapView() {
        view.setEventsMapView();
    }

    @Override
    public void setProfileView() {
        view.setProfileView();
    }

    @Override
    public void setSubscribtionView() {
        view.setEventSubscribtionView();
    }
}
