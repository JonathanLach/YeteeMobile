package com.android.yetee.yeteemobile.dataAccess;

import com.android.yetee.yeteemobile.model.Event;
import com.android.yetee.yeteemobile.model.IdFilter;
import com.android.yetee.yeteemobile.util.AsyncCallbackTwoParam;
import com.android.yetee.yeteemobile.util.ServiceResultState;

import java.util.List;
import java.util.Set;

public interface EventDAO {
    void getEventById(Long id, AsyncCallbackTwoParam<Event, ServiceResultState> callback);

    void getAllEvents(AsyncCallbackTwoParam<List<Event>, ServiceResultState> callback);

    void getSubscribtions(List<IdFilter> eventsId, AsyncCallbackTwoParam<List<Event>, ServiceResultState> callback);
}
