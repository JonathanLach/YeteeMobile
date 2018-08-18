package com.android.yetee.yeteemobile.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.constants.FragmentTagsConstants;
import com.android.yetee.yeteemobile.constants.IntentConstants;
import com.android.yetee.yeteemobile.contract.EventsListContract;
import com.android.yetee.yeteemobile.fragment.EventDetailsFragment;
import com.android.yetee.yeteemobile.fragment.EventsListFragment;
import com.android.yetee.yeteemobile.model.Event;
import com.android.yetee.yeteemobile.viewHolder.EventsListViewHolder;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class EventsListActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_list);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_dialog_alert);
        getSupportActionBar().setTitle("Yetee");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        showEventsListFragment();
        if(getResources().getBoolean(R.bool.isTablet)) {
            showEventDetailsFragment();
        }
    }

    private void showEventDetailsFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fTransaction = fm.beginTransaction();
        EventDetailsFragment eventDetailsFragment = (EventDetailsFragment) fm.findFragmentByTag(FragmentTagsConstants.EVENT_LIST_TAG);
        eventDetailsFragment = new EventDetailsFragment();
        fTransaction.replace(R.id.eventDetailsPane, eventDetailsFragment);
        fTransaction.addToBackStack(FragmentTagsConstants.EVENT_LIST_TAG);
        fTransaction.commit();
    }

    private void showEventsListFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fTransaction = fm.beginTransaction();
        EventsListFragment eventsListFragment = (EventsListFragment) fm.findFragmentByTag(FragmentTagsConstants.EVENT_LIST_TAG);
        eventsListFragment = new EventsListFragment();
        fTransaction.replace(R.id.eventsListPane, eventsListFragment);
        fTransaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }
}
