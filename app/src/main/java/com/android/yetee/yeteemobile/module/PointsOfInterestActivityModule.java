package com.android.yetee.yeteemobile.module;

import com.android.yetee.yeteemobile.activity.PointsOfInterestActivity;
import com.android.yetee.yeteemobile.contract.PointsOfInterestContract;
import com.android.yetee.yeteemobile.presenter.PointsOfInterestPresenterImpl;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import static com.android.yetee.yeteemobile.module.BaseActivityModule.getManagerComponents;

@Module
public abstract class PointsOfInterestActivityModule {

    @Binds
    public abstract PointsOfInterestContract.View view(PointsOfInterestActivity pointsOfInterestActivity);

    @Provides
    static PointsOfInterestContract.Presenter provideEventMapPresenter(PointsOfInterestContract.View view) {
        return new PointsOfInterestPresenterImpl(view, getManagerComponents().getPointOfInterestManager());
    }
}
