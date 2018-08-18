package com.android.yetee.yeteemobile.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.contract.EventSubscribtionsContract;
import com.android.yetee.yeteemobile.contract.MainContract;
import com.android.yetee.yeteemobile.viewHolder.EventSubscribtionsViewHolder;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class EventSubscribtionsActivity extends MainActivity implements EventSubscribtionsContract.View {
    @Inject
    EventSubscribtionsViewHolder viewHolder;

    @Inject
    EventSubscribtionsContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_subscribtions);
        ButterKnife.bind(this);
        ButterKnife.bind(viewHolder, this);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_dialog_alert);
        getSupportActionBar().setTitle("Yetee");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewHolder.setContext(getApplicationContext());
        presenter.getSubscribtions();
    }

    @Override
    public EventSubscribtionsViewHolder getViewHolder() {
        return viewHolder;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
