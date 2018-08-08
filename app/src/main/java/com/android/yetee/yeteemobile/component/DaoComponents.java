package com.android.yetee.yeteemobile.component;

import com.android.yetee.yeteemobile.dataAccess.PointOfInterestDAO;
import com.android.yetee.yeteemobile.dataAccess.UserDAO;
import com.android.yetee.yeteemobile.module.ClientServiceModule;
import com.android.yetee.yeteemobile.module.DaoBindingsModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DaoBindingsModule.class, ClientServiceModule.class})
public interface DaoComponents {
    UserDAO getUserDAO();
    PointOfInterestDAO getPointOfInterestDAO();
}