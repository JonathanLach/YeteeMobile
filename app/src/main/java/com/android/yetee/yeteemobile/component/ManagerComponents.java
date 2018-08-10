package com.android.yetee.yeteemobile.component;

import com.android.yetee.yeteemobile.business.EventManager;
import com.android.yetee.yeteemobile.business.PointOfInterestManager;
import com.android.yetee.yeteemobile.business.UserManager;
import com.android.yetee.yeteemobile.module.AppModule;
import com.android.yetee.yeteemobile.module.ManagerBindingsModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={AppModule.class, ManagerBindingsModule.class})
public interface ManagerComponents {
    UserManager getUserManager();
    PointOfInterestManager getPointOfInterestManager();
    EventManager getEventManager();
}