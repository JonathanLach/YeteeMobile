package com.android.yetee.yeteemobile.presenter;

import com.android.yetee.yeteemobile.R;
import com.android.yetee.yeteemobile.business.UserManager;
import com.android.yetee.yeteemobile.contract.RegisterContract;
import com.android.yetee.yeteemobile.model.User;
import com.android.yetee.yeteemobile.util.AsyncCallbackOneParam;
import com.android.yetee.yeteemobile.util.NotificationUtil;
import com.android.yetee.yeteemobile.util.ServiceResultState;
import com.android.yetee.yeteemobile.util.VerificationErrorCodes;
import com.android.yetee.yeteemobile.viewHolder.RegisterViewHolder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.OnClick;

public class RegisterPresenterImpl implements RegisterContract.Presenter {

    private RegisterContract.View view;
    private UserManager userManager;
    private RegisterViewHolder viewHolder;

    @Inject
    public RegisterPresenterImpl(RegisterContract.View view, UserManager userManager, RegisterViewHolder viewHolder) {
        this.view = view;
        this.userManager = userManager;
        this.viewHolder = viewHolder;
    }

    @OnClick(R.id.registerButton)
    public void register() {
        List<VerificationErrorCodes> errorCodes = verificationRegisterInputs();
        if(errorCodes.size() > 0) {
            NotificationUtil.notifyRegisterErrorDialog(view, null, errorCodes);
        }
        else {
            User user = new User();
            user.setLogin(viewHolder.getUsername());
            user.setPassword(viewHolder.getPassword());
            user.setAddress(viewHolder.getAddress());
            user.setBirthDate(viewHolder.getBirthDate());
            user.setCity(viewHolder.getCity());
            user.setFirstName(viewHolder.getFirstName());
            user.setLastName(viewHolder.getLastName());
            user.setIbanAccount(viewHolder.getIbanAccount());
            user.setZip(viewHolder.getZip());
            user.setTelNumber(viewHolder.getTelNumber());
            AsyncCallbackOneParam<ServiceResultState> callback = (serviceResultState) -> {
                if (serviceResultState == ServiceResultState.OK) {
                    view.setLoginView();
                } else {
                    NotificationUtil.notifyRegisterErrorDialog(view, serviceResultState);
                }
            };
            userManager.register(user, callback);
        }
    }

    public List<VerificationErrorCodes> verificationRegisterInputs() {
        List<VerificationErrorCodes> errorCodes = new ArrayList<>();
        if (viewHolder.getAddress() == null || viewHolder.getAddress().isEmpty()) {
            errorCodes.add(VerificationErrorCodes.ADDRESS_EMPTY);
        }
        if (viewHolder.getBirthDate().after(new Date())) {
            errorCodes.add(VerificationErrorCodes.BIRTHDATE_FUTURE);
        }
        if (viewHolder.getCity() == null || viewHolder.getCity().isEmpty()) {
            errorCodes.add(VerificationErrorCodes.CITY_EMPTY);
        }
        if (viewHolder.getFirstName() == null || viewHolder.getFirstName().isEmpty()) {
            errorCodes.add(VerificationErrorCodes.FIRST_NAME_EMPTY);
        }
        if (viewHolder.getTelNumber() == null || viewHolder.getTelNumber().isEmpty()) {
            errorCodes.add(VerificationErrorCodes.TEL_NUMBER_EMPTY);
        }
        if (viewHolder.getZip() == null || viewHolder.getZip().isEmpty()) {
            errorCodes.add(VerificationErrorCodes.ZIP_EMPTY);
        }
        else {
            if(viewHolder.getZip().length() != 4) {
                errorCodes.add(VerificationErrorCodes.ZIP_NOT_4_DIGITS);
            }
        }
        if (viewHolder.getUsername() == null || viewHolder.getUsername().isEmpty()) {
            errorCodes.add(VerificationErrorCodes.USERNAME_EMPTY);
        }
        if (viewHolder.getPassword() == null || viewHolder.getPassword().isEmpty()) {
            errorCodes.add(VerificationErrorCodes.PASSWORD_EMPTY);
        }
        if (viewHolder.getPasswordConfirmation() == null || viewHolder.getPasswordConfirmation().isEmpty()) {
            errorCodes.add(VerificationErrorCodes.CONFIRMATION_PASSWORD_EMPTY);
        }
        if (!viewHolder.getPassword().equals(viewHolder.getPasswordConfirmation())) {
            errorCodes.add(VerificationErrorCodes.PASSWORDS_NOT_MATCH);
        }
        return errorCodes;
    }
}
