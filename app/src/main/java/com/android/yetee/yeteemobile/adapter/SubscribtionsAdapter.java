package com.android.yetee.yeteemobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.model.Event;
import com.android.yetee.yeteemobile.viewHolder.EventSubscribtionsViewHolder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        viewHolder.setSubscribtionDate(convertView.findViewById(R.id.subscribtionDate));
        viewHolder.setSubscribtionName(convertView.findViewById(R.id.subscribtionName));
        viewHolder.setSubscribtionCategory(convertView.findViewById(R.id.subscribtionCategory));
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        viewHolder.getSubscribtionDate().setText(df.format(item.getEventDate()));
        viewHolder.getSubscribtionName().setText(item.getName());
        viewHolder.getSubscribtionCategory().setText(item.getEventCategory().getName());

        return convertView;
    }
}
