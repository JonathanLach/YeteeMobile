package com.android.yetee.yeteemobile.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.contract.ProfileContract;
import com.android.yetee.yeteemobile.viewHolder.ProfileViewHolder;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class ProfileActivity extends MainActivity implements ProfileContract.View {

    @Inject
    ProfileViewHolder viewHolder;

    @Inject
    ProfileContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        ButterKnife.bind(viewHolder, this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.title_profile));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        presenter.getProfile(getApplicationContext());

    }

    @Override
    public ProfileViewHolder getViewHolder() {
        return viewHolder;
    }
}
