package com.android.yetee.yeteemobile.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.app.YeteeApplication;
import com.android.yetee.yeteemobile.business.EventManager;
import com.android.yetee.yeteemobile.constants.SharedPreferencesConstants;
import com.android.yetee.yeteemobile.contract.EventDetailsContract;
import com.android.yetee.yeteemobile.model.Event;
import com.android.yetee.yeteemobile.util.AsyncCallbackTwoParam;
import com.android.yetee.yeteemobile.util.NotificationUtil;
import com.android.yetee.yeteemobile.util.ServiceResultState;
import com.android.yetee.yeteemobile.viewHolder.EventDetailsViewHolder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

public class EventDetailsPresenterImpl implements EventDetailsContract.Presenter {

    private EventManager eventManager;
    private EventDetailsContract.View view;
    private EventDetailsViewHolder viewHolder;

    @Inject
    public EventDetailsPresenterImpl(EventDetailsContract.View view, EventManager eventManager, EventDetailsViewHolder viewHolder) {
        this.view = view;
        this.eventManager = eventManager;
        this.viewHolder = viewHolder;
    }


    @Override
    public void getEventDetails(Long id) {
            AsyncCallbackTwoParam<Event, ServiceResultState> callback = (event, statusCode) -> {
                if(statusCode != ServiceResultState.OK) {
                    NotificationUtil.notifyCommonErrorDialog(view, statusCode);
                }
                else {
                    viewHolder.setEventAddress(event.getAddress());
                    viewHolder.setEventCategory(event.getEventCategory().getName());
                    viewHolder.setEventCity(event.getCity());
                    viewHolder.setEventZIP(event.getZIP());
                    viewHolder.setEventCompany(event.getCompany().getName());
                    viewHolder.setEventDescription(event.getDescription());
                    viewHolder.setEventName(event.getName());
                    viewHolder.setEventTicketPrice(String.valueOf(event.getTicketPrice()));
                }
            };
            eventManager.getEventById(id, callback);
    }

    @Override
    public void subscribeToEvent(Long id, Context context) {
        SharedPreferences sharedPreferences = YeteeApplication.getYeteeContext().getSharedPreferences(SharedPreferencesConstants.EVENT_PREFERENCES, Context.MODE_PRIVATE);
        Set<String> subscribedEvents = sharedPreferences.getStringSet(SharedPreferencesConstants.EVENT_ID, new HashSet<>());
        if(!subscribedEvents.contains(String.valueOf(id))) {
            subscribedEvents.add(String.valueOf(id));
            sharedPreferences.edit().putStringSet(SharedPreferencesConstants.EVENT_ID, subscribedEvents).apply();
            view.sendSuccessDialog(view.getStringValue(R.string.success_subsribtion));
        }
        else {
            view.sendErrorDialog(view.getStringValue(R.string.error_already_sub));
        }
    }
}
