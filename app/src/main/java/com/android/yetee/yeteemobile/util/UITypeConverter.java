package com.android.yetee.yeteemobile.util;

import android.widget.EditText;

public class UITypeConverter {

    public static String toString(EditText editText) {
        return editText.getText().toString();
    }

    public static Integer toInteger(EditText editText) {
        return Integer.valueOf(toString(editText));
    }

    public static Double toDouble(EditText editText) {
        return Double.valueOf(toString(editText));
    }
}