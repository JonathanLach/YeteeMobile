package com.android.yetee.yeteemobile.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.contract.EventsListContract;
import com.android.yetee.yeteemobile.model.Event;
import com.android.yetee.yeteemobile.viewHolder.EventsListViewHolder;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class EventsListActivity extends MainActivity implements EventsListContract.View  {

    @Inject
    EventsListViewHolder viewHolder;

    @Inject
    EventsListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_list);
        ButterKnife.bind(this);
        ButterKnife.bind(viewHolder, this);
        viewHolder.setContext(getApplicationContext());
        presenter.getAllEvents();
    }

    @Override
    public EventsListViewHolder getViewHolder() {
        return viewHolder;
    }

    @OnItemClick(R.id.eventsList)
    public void onItemClick(AdapterView<?> parent, int position) {
        ListView listView = (ListView)findViewById(R.id.eventsList);
        Event event = (Event)listView.getAdapter().getItem(position);
        Intent intent = new Intent(getBaseContext(), EventDetailsActivity.class);
        intent.putExtra("EVENT_ID", String.valueOf(event.getEventId()));
        startActivity(intent);
    }
}
