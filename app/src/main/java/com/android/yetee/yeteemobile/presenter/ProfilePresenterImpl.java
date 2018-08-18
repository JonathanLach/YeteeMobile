package com.android.yetee.yeteemobile.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.yetee.yeteemobile.business.UserManager;
import com.android.yetee.yeteemobile.constants.SharedPreferencesConstants;
import com.android.yetee.yeteemobile.contract.ProfileContract;
import com.android.yetee.yeteemobile.model.User;
import com.android.yetee.yeteemobile.util.AsyncCallbackTwoParam;
import com.android.yetee.yeteemobile.util.NotificationUtil;
import com.android.yetee.yeteemobile.util.ServiceResultState;
import com.android.yetee.yeteemobile.viewHolder.ProfileViewHolder;

import javax.inject.Inject;

public class ProfilePresenterImpl implements ProfileContract.Presenter {

    private ProfileContract.View view;
    private UserManager userManager;
    private ProfileViewHolder viewHolder;

    @Inject
    public ProfilePresenterImpl(ProfileContract.View view,UserManager userManager,ProfileViewHolder viewHolder) {
        this.view = view;
        this.userManager = userManager;
        this.viewHolder = viewHolder;
    }

    public void getProfile(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferencesConstants.USER_PREFERENCES, Context.MODE_PRIVATE);
        AsyncCallbackTwoParam<User, ServiceResultState> callback = (user, serviceResultState) -> {
          if(serviceResultState == ServiceResultState.OK) {
              viewHolder.setAddress(user.getAddress());
              viewHolder.setCity(user.getCity());
              viewHolder.setFirstName(user.getFirstName());
              viewHolder.setIban(user.getIbanAccount());
              viewHolder.setLastName(user.getLastName());
              viewHolder.setZip(user.getZip());
          }
          else {
              NotificationUtil.notifyCommonErrorDialog(view, serviceResultState);
          }
        };
        userManager.getProfile(sharedPreferences.getString(SharedPreferencesConstants.USER_USERNAME, ""), callback);
    }
}
