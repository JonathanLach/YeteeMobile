package com.android.yetee.yeteemobile.module;

import com.android.yetee.yeteemobile.activity.LoginActivity;
import com.android.yetee.yeteemobile.contract.LoginContract;
import com.android.yetee.yeteemobile.presenter.LoginPresenterImpl;
import com.android.yetee.yeteemobile.viewHolder.LoginViewHolder;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class LoginActivityModule extends BaseActivityModule {

    @Binds
    public abstract LoginContract.View view(LoginActivity loginActivity);

    @Provides
    static LoginViewHolder provideLoginViewHolder(LoginContract.View view) {
        return new LoginViewHolder();
    }

    @Provides
    static LoginContract.Presenter provideMainPresenter(LoginContract.View view) {
        return new LoginPresenterImpl(view, getManagerComponents().getUserManager(), view.getLoginViewHolder());
    }
}
