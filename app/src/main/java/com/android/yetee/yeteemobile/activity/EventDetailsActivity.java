package com.android.yetee.yeteemobile.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.contract.EventDetailsContract;
import com.android.yetee.yeteemobile.viewHolder.EventDetailsViewHolder;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class EventDetailsActivity extends MainActivity implements EventDetailsContract.View {

    @Inject
    EventDetailsViewHolder viewHolder;

    @Inject
    EventDetailsContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        ButterKnife.bind(this);
        ButterKnife.bind(viewHolder, this);
        presenter.getEventDetails(Long.valueOf(getIntent().getStringExtra("EVENT_ID")));
    }

    @Override
    public EventDetailsViewHolder getViewHolder() {
        return viewHolder;
    }
}
