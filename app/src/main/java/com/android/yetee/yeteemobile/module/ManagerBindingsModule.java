package com.android.yetee.yeteemobile.module;

import com.android.yetee.yeteemobile.business.EventManager;
import com.android.yetee.yeteemobile.business.PointOfInterestManager;
import com.android.yetee.yeteemobile.business.UserManager;
import com.android.yetee.yeteemobile.component.DaggerDaoComponents;
import com.android.yetee.yeteemobile.component.DaoComponents;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ManagerBindingsModule {
    private DaoComponents daoAccessor = DaggerDaoComponents
            .builder().build();

    @Provides
    @Singleton
    UserManager provideUserManager() {
        return new UserManager(daoAccessor.getUserDAO());
    }

    @Provides
    @Singleton
    PointOfInterestManager providePointOfInterestManager() {
        return new PointOfInterestManager(daoAccessor.getPointOfInterestDAO());
    }

    @Provides
    @Singleton
    EventManager provideEventManager() {
        return new EventManager(daoAccessor.getEventDAO());
    }
}