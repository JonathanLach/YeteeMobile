package com.android.yetee.yeteemobile.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.activity.PointsOfInterestActivity;
import com.android.yetee.yeteemobile.constants.IntentConstants;
import com.android.yetee.yeteemobile.contract.EventDetailsContract;
import com.android.yetee.yeteemobile.viewHolder.EventDetailsViewHolder;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class EventDetailsFragment extends MainFragment implements EventDetailsContract.View {

    @Inject
    EventDetailsViewHolder viewHolder;

    @Inject
    EventDetailsContract.Presenter presenter;

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
        ButterKnife.bind(presenter, getView());
        if (getArguments() != null) {
            presenter.getEventDetails(getArguments().getLong(IntentConstants.EVENT_ID));
            getView().findViewById(R.id.registrationEvent).setVisibility(VISIBLE);
            getView().findViewById(R.id.seePointsOfInterest).setVisibility(VISIBLE);
        }
        else {
            getView().findViewById(R.id.registrationEvent).setVisibility(INVISIBLE);
            getView().findViewById(R.id.seePointsOfInterest).setVisibility(INVISIBLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_details, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void updateDetails(Long id) {
        presenter.getEventDetails(id);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    @OnClick(R.id.registrationEvent)
    public void subscribeToEvent() {
        presenter.subscribeToEvent(getArguments().getLong(IntentConstants.EVENT_ID), getContext());
    }

    @Override
    public void setPointsOfInterest() {
        Intent intent = new Intent(getContext(), PointsOfInterestActivity.class);
        intent.putExtra("EVENT_ID", getArguments().getLong(IntentConstants.EVENT_ID));
        startActivity(intent);
    }

    @Override
    public EventDetailsViewHolder getViewHolder() {
        return viewHolder;
    }

}
