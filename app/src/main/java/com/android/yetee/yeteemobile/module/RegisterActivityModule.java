package com.android.yetee.yeteemobile.module;

import com.android.yetee.yeteemobile.activity.RegisterActivity;
import com.android.yetee.yeteemobile.contract.RegisterContract;
import com.android.yetee.yeteemobile.presenter.RegisterPresenterImpl;
import com.android.yetee.yeteemobile.viewHolder.RegisterViewHolder;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class RegisterActivityModule extends BaseActivityModule {

    @Binds
    public abstract RegisterContract.View view(RegisterActivity registerActivity);

    @Provides
    static RegisterViewHolder provideLoginViewHolder(RegisterContract.View view) {
        return new RegisterViewHolder();
    }

    @Provides
    static RegisterContract.Presenter provideMainPresenter(RegisterContract.View view) {
        return new RegisterPresenterImpl(view, getManagerComponents().getUserManager(), view.getRegisterViewHolder());
    }
}