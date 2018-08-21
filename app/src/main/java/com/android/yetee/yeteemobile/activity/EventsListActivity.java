package com.android.yetee.yeteemobile.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.constants.FragmentTagsConstants;
import com.android.yetee.yeteemobile.fragment.EventDetailsFragment;
import com.android.yetee.yeteemobile.fragment.EventsListFragment;

import butterknife.ButterKnife;

public class EventsListActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_list);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.title_events_list));
        toolbar.setNavigationIcon(android.R.drawable.ic_dialog_alert);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        showEventsListFragment();
        if(getResources().getBoolean(R.bool.isTablet) || getResources().getBoolean(R.bool.isLandscape)) {
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
}
