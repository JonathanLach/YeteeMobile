package com.android.yetee.yeteemobile.presenter;

import com.android.yetee.yeteemobile.business.EventManager;
import com.android.yetee.yeteemobile.contract.EventsListContract;
import com.android.yetee.yeteemobile.model.Event;
import com.android.yetee.yeteemobile.util.AsyncCallbackTwoParam;
import com.android.yetee.yeteemobile.util.NotificationUtil;
import com.android.yetee.yeteemobile.util.ServiceResultState;
import com.android.yetee.yeteemobile.viewHolder.EventsListViewHolder;

import java.util.List;

import javax.inject.Inject;

public class EventsListPresenterImpl implements EventsListContract.Presenter {

    private EventsListContract.View view;
    private EventManager eventManager;
    private EventsListViewHolder viewHolder;

    @Inject
    public EventsListPresenterImpl(EventsListContract.View view, EventManager eventManager, EventsListViewHolder eventsListViewHolder) {
        this.view = view;
        this.eventManager = eventManager;
        this.viewHolder = eventsListViewHolder;
    }


    @Override
    public void setDetailsView(int position) {
        view.setDetailsView(viewHolder.getAdapter().getItem(position).getEventId());
    }

    @Override
    public void getAllEvents() {
        AsyncCallbackTwoParam<List<Event>, ServiceResultState> callback = (events, statusCode) -> {
            if(statusCode != ServiceResultState.OK) {
                NotificationUtil.notifyCommonErrorDialog(view, statusCode);
            }
            else {
                if(events != null) {
                    viewHolder.setList(events);
                }
            }
        };
        eventManager.getAllEvents(callback);
    }
}
