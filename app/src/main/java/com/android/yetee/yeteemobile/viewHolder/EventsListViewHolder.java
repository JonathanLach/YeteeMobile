package com.android.yetee.yeteemobile.viewHolder;

import android.content.Context;
import android.widget.ListView;
import android.widget.TextView;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.adapter.EventAdapter;
import com.android.yetee.yeteemobile.model.Event;

import java.util.List;

import butterknife.BindView;

public class EventsListViewHolder {

    @BindView(R.id.eventsList)
    ListView eventsList;

    TextView eventDate;

    TextView eventName;

    TextView eventCategory;

    private  EventAdapter adapter;
    private Context context;

    public void setList(List<Event> events) {
        adapter = new EventAdapter(context,
                android.R.layout.simple_list_item_1, events);
        eventsList.setAdapter(adapter);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public TextView getEventName() {
        return eventName;
    }

    public TextView getEventDate() {
        return eventDate;
    }

    public TextView getEventCategory() {
        return eventCategory;
    }

    public void setEventDate(TextView eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventName(TextView eventName) {
        this.eventName = eventName;
    }

    public void setEventCategory(TextView eventCategory) {
        this.eventCategory = eventCategory;
    }

    public EventAdapter getAdapter() {
        return adapter;
    }
}
