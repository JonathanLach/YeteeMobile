package com.android.yetee.yeteemobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.contract.LoginContract;
import com.android.yetee.yeteemobile.presenter.LoginPresenterImpl;
import com.android.yetee.yeteemobile.viewHolder.LoginViewHolder;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends MainActivity implements LoginContract.View {
    @Inject
    LoginViewHolder loginViewHolder;

    @Inject
    LoginContract.Presenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ButterKnife.bind(loginViewHolder, this);
    }

    @Override
    @OnClick(R.id.login)
    public void login() {
        loginPresenter.login();
    }

    @Override
    public void setEventMapView() {
        startActivity(new Intent(this, EventMapActivity.class));
        finish();
    }

    @Override
    public LoginViewHolder getLoginViewHolder() {
        return loginViewHolder;
    }
}
