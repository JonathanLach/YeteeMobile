package com.android.yetee.yeteemobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.model.Event;
import com.android.yetee.yeteemobile.viewHolder.EventSubscribtionsViewHolder;

import java.util.List;

public class SubscribtionsAdapter extends ArrayAdapter<Event> {

    public SubscribtionsAdapter(Context context, int resource, List<Event> events) {
        super(context, resource, events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Event item = getItem(position);

        EventSubscribtionsViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new EventSubscribtionsViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.subscribtion_list_item, parent, false);
            convertView.setTag(viewHolder); // view lookup cache stored in tag
        } else {
            viewHolder = (EventSubscribtionsViewHolder)convertView.getTag();
        }

        viewHolder.setSubscribtionId(convertView.findViewById(R.id.subscritionId));
        viewHolder.setSubscribtionName(convertView.findViewById(R.id.subscritionName));
        viewHolder.setSubscribtionCategory(convertView.findViewById(R.id.subscritionCategory));
        viewHolder.getSubscribtionId().setText(item.getEventId().toString());
        viewHolder.getSubscribtionName().setText(item.getName());
        viewHolder.getSubscribtionCategory().setText(item.getEventCategory().getName());

        return convertView;
    }
}
