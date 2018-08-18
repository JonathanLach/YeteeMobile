package com.android.yetee.yeteemobile.module;

import com.android.yetee.yeteemobile.activity.ProfileActivity;
import com.android.yetee.yeteemobile.contract.ProfileContract;
import com.android.yetee.yeteemobile.presenter.ProfilePresenterImpl;
import com.android.yetee.yeteemobile.viewHolder.ProfileViewHolder;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ProfileActivityModule extends BaseActivityModule {
    @Binds
    public abstract ProfileContract.View view(ProfileActivity registerActivity);

    @Provides
    static ProfileViewHolder provideLoginViewHolder(ProfileContract.View view) {
        return new ProfileViewHolder();
    }

    @Provides
    static ProfileContract.Presenter provideMainPresenter(ProfileContract.View view) {
        return new ProfilePresenterImpl(view, getManagerComponents().getUserManager(), view.getViewHolder());
    }
}
