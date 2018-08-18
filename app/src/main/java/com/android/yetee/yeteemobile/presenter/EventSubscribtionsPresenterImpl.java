package com.android.yetee.yeteemobile.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.yetee.yeteemobile.app.YeteeApplication;
import com.android.yetee.yeteemobile.business.EventManager;
import com.android.yetee.yeteemobile.constants.SharedPreferencesConstants;
import com.android.yetee.yeteemobile.contract.EventSubscribtionsContract;
import com.android.yetee.yeteemobile.model.Event;
import com.android.yetee.yeteemobile.model.IdFilter;
import com.android.yetee.yeteemobile.util.AsyncCallbackOneParam;
import com.android.yetee.yeteemobile.util.AsyncCallbackTwoParam;
import com.android.yetee.yeteemobile.util.NotificationUtil;
import com.android.yetee.yeteemobile.util.ServiceResultState;
import com.android.yetee.yeteemobile.viewHolder.EventSubscribtionsViewHolder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

public class EventSubscribtionsPresenterImpl implements EventSubscribtionsContract.Presenter {

    private EventSubscribtionsContract.View view;
    private EventManager eventManager;
    private EventSubscribtionsViewHolder viewHolder;

    @Inject
    public EventSubscribtionsPresenterImpl(EventSubscribtionsContract.View view, EventManager eventManager, EventSubscribtionsViewHolder viewHolder) {
            this.view = view;
            this.eventManager = eventManager;
            this.viewHolder = viewHolder;
    }

    public void getSubscribtions() {
        SharedPreferences sharedPreferences = YeteeApplication.getYeteeContext().getSharedPreferences(SharedPreferencesConstants.EVENT_PREFERENCES, Context.MODE_PRIVATE);
        Set<String> subscribedEvents = sharedPreferences.getStringSet(SharedPreferencesConstants.EVENT_ID, new HashSet<>());
        List<IdFilter> subscribtions = new ArrayList<>();
        for(String eventId : subscribedEvents) {
            subscribtions.add(new IdFilter(Long.valueOf(eventId)));
        }

        AsyncCallbackTwoParam<List<Event>, ServiceResultState> callback = (events, serviceResultState) -> {
            if(serviceResultState == ServiceResultState.OK) {
                if(events != null) {
                    viewHolder.setList(events);
                }
            }
            else {
                NotificationUtil.notifyCommonErrorDialog(view, serviceResultState);
            }
        };
        eventManager.getSubscribtions(subscribtions, callback);
    }
}
