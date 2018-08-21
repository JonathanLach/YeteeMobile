package com.android.yetee.yeteemobile.presenter;

import com.android.yetee.yeteemobile.business.EventManager;
import com.android.yetee.yeteemobile.contract.EventMapContract;
import com.android.yetee.yeteemobile.model.Event;
import com.android.yetee.yeteemobile.util.AsyncCallbackTwoParam;
import com.android.yetee.yeteemobile.util.NotificationUtil;
import com.android.yetee.yeteemobile.util.ServiceResultState;

import java.util.List;

import javax.inject.Inject;

public class EventMapPresenterImpl implements EventMapContract.Presenter {
    private EventMapContract.View view;

    private EventManager eventManager;

    @Inject
    public EventMapPresenterImpl(EventMapContract.View view, EventManager eventManager) {
        this.view = view;
        this.eventManager = eventManager;
    }

    public void getEventLocations() {
        AsyncCallbackTwoParam<List<Event>, ServiceResultState> callback = (events, serviceResultState) -> {
            if(serviceResultState != ServiceResultState.OK) {
                NotificationUtil.notifyCommonErrorDialog(view, serviceResultState);
            }
            else {
                for(Event event : events) {
                    view.addMarkerMap(event.getLocation().getLatitude(), event.getLocation().getLongitude(), event.getName());
                }
            }
        };
        eventManager.getAllEvents(callback);
    }
}
