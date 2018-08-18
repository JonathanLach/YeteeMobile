package com.android.yetee.yeteemobile.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.contract.RegisterContract;
import com.android.yetee.yeteemobile.viewHolder.RegisterViewHolder;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends MainActivity implements RegisterContract.View {

    @Inject
    RegisterViewHolder viewHolder;

    @Inject
    RegisterContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        ButterKnife.bind(viewHolder, this);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_dialog_alert);
        getSupportActionBar().setTitle("Yetee");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public RegisterViewHolder getRegisterViewHolder() {
        return viewHolder;
    }

    @Override
    @OnClick(R.id.registerButton)
    public void onClickRegisterButton() {
        presenter.register();
    }

    @Override
    public void setLoginView() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
