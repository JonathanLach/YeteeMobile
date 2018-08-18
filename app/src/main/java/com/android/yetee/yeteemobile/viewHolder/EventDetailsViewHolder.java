package com.android.yetee.yeteemobile.viewHolder;

import android.widget.TextView;

import com.android.yetee.yeteemobile.R;

import butterknife.BindView;

public class EventDetailsViewHolder {
    @BindView(R.id.eventDetailsName)
    TextView eventName;

    @BindView(R.id.eventDetailsId)
    TextView eventId;

    @BindView(R.id.eventDetailsCategory)
    TextView eventCategory;

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

    public void setEventId(Long id) {
        eventId.setText(String.valueOf(id));
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
