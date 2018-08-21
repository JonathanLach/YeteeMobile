package com.android.yetee.yeteemobile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.app.YeteeApplication;
import com.android.yetee.yeteemobile.constants.SharedPreferencesConstants;
import com.android.yetee.yeteemobile.contract.LoginContract;
import com.android.yetee.yeteemobile.contract.MainContract;
import com.android.yetee.yeteemobile.presenter.LoginPresenterImpl;
import com.android.yetee.yeteemobile.viewHolder.LoginViewHolder;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;

public class LoginActivity extends MainActivity implements LoginContract.View {
    @Inject
    LoginViewHolder loginViewHolder;

    @Inject
    LoginContract.Presenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSharedPreferences(SharedPreferencesConstants.USER_PREFERENCES, Context.MODE_PRIVATE).getBoolean(SharedPreferencesConstants.USER_IS_LOGGED, false)) {
            startActivity(new Intent(this, EventsListActivity.class));
            finish();
        }
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ButterKnife.bind(loginPresenter, this);
        ButterKnife.bind(loginViewHolder, this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.title_login));
    }

    @Override
    @OnClick(R.id.login)
    public void login() {
        loginPresenter.login(getSharedPreferences(SharedPreferencesConstants.USER_PREFERENCES, Context.MODE_PRIVATE));
    }

    @Override
    @OnClick(R.id.signup)
    public void onClickRegisterButton() {
        loginPresenter.setRegisterView();
    }

    @Override
    public void setRegisterView() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    @Override
    public void setEventMapView() {
        startActivity(new Intent(this, EventSubscribtionsActivity.class));
        finish();
    }

    @Override
    public LoginViewHolder getLoginViewHolder() {
        return loginViewHolder;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }
}
