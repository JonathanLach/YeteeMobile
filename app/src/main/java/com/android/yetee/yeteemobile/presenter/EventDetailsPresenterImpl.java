package com.android.yetee.yeteemobile.presenter;

import com.android.yetee.yeteemobile.business.EventManager;
import com.android.yetee.yeteemobile.contract.EventDetailsContract;
import com.android.yetee.yeteemobile.model.Event;
import com.android.yetee.yeteemobile.util.AsyncCallbackTwoParam;
import com.android.yetee.yeteemobile.util.NotificationUtil;
import com.android.yetee.yeteemobile.util.ServiceResultState;
import com.android.yetee.yeteemobile.viewHolder.EventDetailsViewHolder;

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
                    viewHolder.setEventId(event.getEventId());
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
}
