package com.android.yetee.yeteemobile.viewHolder;

import android.widget.DatePicker;
import android.widget.EditText;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.contract.RegisterContract;

import java.util.Date;

import butterknife.BindView;

public class RegisterViewHolder {
    @BindView(R.id.loginTextRegister)
    EditText username;

    @BindView(R.id.passwordTextRegister)
    EditText password;

    @BindView(R.id.passwordTextConfirmationRegister)
    EditText passwordConfirmation;

    @BindView(R.id.firstNameTextRegister)
    EditText firstName;

    @BindView(R.id.lastNameTextRegister)
    EditText lastName;

    @BindView(R.id.telNumberTextRegister)
    EditText telNumber;

    @BindView(R.id.addressTextRegister)
    EditText address;

    @BindView(R.id.cityTextRegister)
    EditText city;

    @BindView(R.id.ZIPTextRegister)
    EditText zip;

    @BindView(R.id.ibanAccountTextRegister)
    EditText ibanAccount;

    @BindView(R.id.birthDate)
    DatePicker birthDate;

    public Date getBirthDate() {
        return new Date(birthDate.getYear() - 1900, birthDate.getMonth(), birthDate.getDayOfMonth());
    }

    public String getUsername() {
        return username.getText().toString();
    }

    public String getPassword() {
        return password.getText().toString();
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation.getText().toString();
    }

    public String getFirstName() {
        return firstName.getText().toString();
    }

    public String getLastName() {
        return lastName.getText().toString();
    }

    public String getTelNumber() {
        return telNumber.getText().toString();
    }

    public String getAddress() {
        return address.getText().toString();
    }

    public String getCity() {
        return city.getText().toString();
    }

    public String getZip() {
        return zip.getText().toString();
    }

    public String getIbanAccount() {
        return ibanAccount.getText().toString();
    }
}
