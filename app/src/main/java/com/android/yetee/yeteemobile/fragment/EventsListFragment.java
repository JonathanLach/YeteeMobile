package com.android.yetee.yeteemobile.fragment;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.constants.FragmentTagsConstants;
import com.android.yetee.yeteemobile.constants.IntentConstants;
import com.android.yetee.yeteemobile.contract.EventsListContract;
import com.android.yetee.yeteemobile.model.Event;
import com.android.yetee.yeteemobile.viewHolder.EventsListViewHolder;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsListFragment extends MainFragment implements EventsListContract.View {

    @Inject
    EventsListViewHolder viewHolder;

    @Inject
    EventsListContract.Presenter presenter;

    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(getView());
        ButterKnife.bind(viewHolder, getView());
        viewHolder.setContext(view.getContext());
        presenter.getAllEvents();
        ListView listView = (ListView)getView().findViewById(R.id.eventsList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Event event = (Event)listView.getAdapter().getItem(position);
                showEventDetailsFragment(event.getEventId());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private void showEventDetailsFragment(Long id) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fTransaction = fm.beginTransaction();
        EventDetailsFragment eventDetailsFragment = (EventDetailsFragment) fm.findFragmentByTag(FragmentTagsConstants.EVENT_DETAILS_TAG);
        if (eventDetailsFragment == null) {
            eventDetailsFragment = new EventDetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putLong(IntentConstants.EVENT_ID, id);
            eventDetailsFragment.setArguments(bundle);
            if(!getResources().getBoolean(R.bool.isTablet)) {
                fTransaction.replace(R.id.eventsListPane, eventDetailsFragment);
            }
            else {
                fTransaction.replace(R.id.eventDetailsPane, eventDetailsFragment);
            }
        }
        fTransaction.addToBackStack(FragmentTagsConstants.EVENT_DETAILS_TAG);
        fTransaction.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public EventsListViewHolder getViewHolder() {
        return viewHolder;
    }
}
