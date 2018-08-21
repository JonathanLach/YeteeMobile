package com.android.yetee.yeteemobile.viewHolder;

import android.widget.TextView;

import com.android.yetee.yeteemobile.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;

public class EventDetailsViewHolder {
    @BindView(R.id.eventDetailsName)
    TextView eventName;

    @BindView(R.id.eventDetailsCategory)
    TextView eventCategory;

    @BindView(R.id.eventDetailsDate)
    TextView eventDate;

    @BindView(R.id.eventDetailsDescription)
    TextView eventDescription;

    @BindView(R.id.eventDetailsTicketPrice)
    TextView eventTicketPrice;

    @BindView(R.id.eventDetailsCompany)
    TextView eventCompany;

    @BindView(R.id.eventDetailsAddress)
    TextView eventAddress;

    @BindView(R.id.eventDetailsZIP)
    TextView eventZIP;

    @BindView(R.id.eventDetailsCity)
    TextView eventCity;

    public void setEventName(String name) {
        eventName.setText(name);
    }

    public void setEventCategory(String category) {
        eventCategory.setText(category);
    }

    public void setEventDescription(String description) {
        eventDescription.setText(description);
    }

    public void setEventTicketPrice(String ticketPrice) {
        eventTicketPrice.setText(ticketPrice);

    }

    public void setEventDate(Date date) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        eventDate.setText(df.format(date));
    }

    public void setEventCompany(String company) {
        eventCompany.setText(company);
    }

    public void setEventAddress(String address) {
        eventAddress.setText(address);
    }

    public void setEventZIP(String zip) {
        eventZIP.setText(zip);
    }

    public void setEventCity(String city) {
        eventCity.setText(city);
    }
}
