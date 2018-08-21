package com.android.yetee.yeteemobile.business;

import com.android.yetee.yeteemobile.dataAccess.EventDAO;
import com.android.yetee.yeteemobile.model.Event;
import com.android.yetee.yeteemobile.model.IdFilter;
import com.android.yetee.yeteemobile.util.AsyncCallbackTwoParam;
import com.android.yetee.yeteemobile.util.ServiceResultState;

import java.util.List;

import javax.inject.Inject;

public class EventManager {

    private EventDAO eventDAO;

    @Inject
    public EventManager(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public void getAllEvents(AsyncCallbackTwoParam<List<Event>, ServiceResultState> callback) {
        eventDAO.getAllEvents(callback);
    }

    public void getEventById(Long id, AsyncCallbackTwoParam<Event, ServiceResultState> callback) {
        eventDAO.getEventById(id, callback);
    }

    public void getSubscribtions(List<IdFilter> eventsId, AsyncCallbackTwoParam<List<Event>, ServiceResultState> callback) {
        eventDAO.getSubscribtions(eventsId, callback);
    }
}
