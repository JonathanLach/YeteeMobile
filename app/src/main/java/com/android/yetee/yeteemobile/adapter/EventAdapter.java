package com.android.yetee.yeteemobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.model.Event;
import com.android.yetee.yeteemobile.viewHolder.EventsListViewHolder;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class EventAdapter extends ArrayAdapter<Event> {

    public EventAdapter(Context context, int resource, List<Event> events) {
        super(context, resource, events);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Event item = getItem(position);

        EventsListViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new EventsListViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.event_list_item, parent, false);
            convertView.setTag(viewHolder); // view lookup cache stored in tag
        } else {
            viewHolder = (EventsListViewHolder)convertView.getTag();
        }
        viewHolder.setEventName((TextView)convertView.findViewById(R.id.eventName));
        viewHolder.setEventDate((TextView)convertView.findViewById(R.id.eventDate));
        viewHolder.setEventCategory((TextView)convertView.findViewById(R.id.eventCategory));
        viewHolder.getEventName().setText(item.getName());
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        viewHolder.getEventDate().setText(df.format(item.getEventDate()));
        viewHolder.getEventCategory().setText(item.getEventCategory().getName());

        return convertView;
    }
}