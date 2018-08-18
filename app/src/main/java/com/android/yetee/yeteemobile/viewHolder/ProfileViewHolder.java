package com.android.yetee.yeteemobile.viewHolder;

import android.widget.TextView;

import com.android.yetee.yeteemobile.R;

import butterknife.BindView;

public class ProfileViewHolder {

    @BindView(R.id.profileAddress)
    TextView address;

    @BindView(R.id.profileCity)
    TextView city;

    @BindView(R.id.profileFirstName)
    TextView firstName;

    @BindView(R.id.profileIban)
    TextView iban;

    @BindView(R.id.profileLastName)
    TextView lastName;

    @BindView(R.id.profileUsername)
    TextView username;

    @BindView(R.id.profileZIP)
    TextView zip;

    public void setAddress(String address) {
        this.address.setText(address);
    }

    public void setCity(String city) {
        this.city.setText(city);
    }

    public void setFirstName(String firstName) {
        this.firstName.setText(firstName);
    }

    public void setIban(String iban) {
        this.iban.setText(iban);
    }

    public void setLastName(String lastName) {
        this.lastName.setText(lastName);
    }

    public void setUsername(String username) {
        this.username.setText(username);
    }

    public void setZip(String zip) {
        this.zip.setText(zip);
    }
}
