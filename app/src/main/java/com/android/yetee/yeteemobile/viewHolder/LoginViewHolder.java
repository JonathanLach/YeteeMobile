package com.android.yetee.yeteemobile.viewHolder;

import android.widget.Button;
import android.widget.EditText;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.util.UITypeConverter;

import butterknife.BindView;

public class LoginViewHolder {

    @BindView(R.id.login)
    Button loginButton;
    @BindView(R.id.loginText)
    EditText login;
    @BindView(R.id.passwordText)
    EditText password;
    @BindView(R.id.signup)
    Button signupButton;

    public String getLogin() {
        return UITypeConverter.toString(login);
    }

    public String getPassword() {
        return UITypeConverter.toString(password);
    }
}
