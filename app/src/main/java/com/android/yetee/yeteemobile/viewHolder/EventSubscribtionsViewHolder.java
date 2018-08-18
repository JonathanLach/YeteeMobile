package com.android.yetee.yeteemobile.viewHolder;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.adapter.EventAdapter;
import com.android.yetee.yeteemobile.adapter.SubscribtionsAdapter;
import com.android.yetee.yeteemobile.model.Event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;

public class EventSubscribtionsViewHolder {

    @BindView(R.id.eventsSubscription)
    ListView eventSubscriptions;

    TextView subscribtionId;

    TextView subscribtionName;

    TextView subscribtionCategory;

    private  SubscribtionsAdapter adapter;
    private Context context;

    public void setList(List<Event> events) {
        adapter = new SubscribtionsAdapter(context,
                android.R.layout.simple_list_item_1, events);
        eventSubscriptions.setAdapter(adapter);
    }

    public void setContext(Context context) {
        this.context = context;
    }


    public ListView getEventSubscriptions() {
        return eventSubscriptions;
    }

    public void setEventSubscriptions(ListView eventSubscriptions) {
        this.eventSubscriptions = eventSubscriptions;
    }

    public TextView getSubscribtionId() {
        return subscribtionId;
    }

    public void setSubscribtionId(TextView subscribtionId) {
        this.subscribtionId = subscribtionId;
    }

    public TextView getSubscribtionName() {
        return subscribtionName;
    }

    public void setSubscribtionName(TextView subscribtionName) {
        this.subscribtionName = subscribtionName;
    }

    public TextView getSubscribtionCategory() {
        return subscribtionCategory;
    }

    public void setSubscribtionCategory(TextView subscribtionCategory) {
        this.subscribtionCategory = subscribtionCategory;
    }

    public void setAdapter(SubscribtionsAdapter adapter) {
        this.adapter = adapter;
    }

    public Context getContext() {
        return context;
    }

    public SubscribtionsAdapter getAdapter() {
        return adapter;
    }
}