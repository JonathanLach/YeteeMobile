package com.android.yetee.yeteemobile.util;

import android.content.res.Resources;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.app.YeteeApplication;

public enum VerificationErrorCodes {
    USERNAME_EMPTY(YeteeApplication.getYeteeContext().getString(R.string.error_empty_username)),
    PASSWORD_EMPTY(YeteeApplication.getYeteeContext().getString(R.string.error_empty_password)),
    CONFIRMATION_PASSWORD_EMPTY(YeteeApplication.getYeteeContext().getString(R.string.error_empty_confirmation_password)),
    FIRST_NAME_EMPTY(YeteeApplication.getYeteeContext().getString(R.string.error_empty_firstname)),
    LAST_NAME_EMPTY(YeteeApplication.getYeteeContext().getString(R.string.error_empty_lastname)),
    TEL_NUMBER_EMPTY(YeteeApplication.getYeteeContext().getString(R.string.error_empty_tel_number)),
    ADDRESS_EMPTY(YeteeApplication.getYeteeContext().getString(R.string.error_empty_address)),
    CITY_EMPTY(YeteeApplication.getYeteeContext().getString(R.string.error_empty_city)),
    PASSWORDS_NOT_MATCH(YeteeApplication.getYeteeContext().getString(R.string.error_passwords_not_match)),
    ZIP_EMPTY(YeteeApplication.getYeteeContext().getString(R.string.error_empty_zip)),
    BIRTHDATE_FUTURE(YeteeApplication.getYeteeContext().getString(R.string.error_birthdate_future));

    private String value;

    VerificationErrorCodes(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
