package com.android.yetee.yeteemobile.module;

import com.android.yetee.yeteemobile.dataAccess.EventDAO;
import com.android.yetee.yeteemobile.dataAccess.PointOfInterestDAO;
import com.android.yetee.yeteemobile.dataAccess.UserDAO;
import com.android.yetee.yeteemobile.dataAccess.impl.EventDAOImpl;
import com.android.yetee.yeteemobile.dataAccess.impl.PointOfInterestDAOImpl;
import com.android.yetee.yeteemobile.dataAccess.impl.UserDAOImpl;

import dagger.Binds;
import dagger.Module;

@Module(includes = ManagerBindingsModule.class)
public interface DaoBindingsModule {

    @Binds
    UserDAO userDAO(UserDAOImpl userDAOImpl);

    @Binds
    PointOfInterestDAO pointOfInterestDAO(PointOfInterestDAOImpl pointOfInterestDAOImpl);

    @Binds
    EventDAO eventDAO(EventDAOImpl eventDAOImpl);
}