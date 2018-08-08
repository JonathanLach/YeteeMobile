package com.android.yetee.yeteemobile.module;

import com.android.yetee.yeteemobile.component.DaggerManagerComponents;
import com.android.yetee.yeteemobile.component.ManagerComponents;

public class BaseActivityModule {

    private static final ManagerComponents MANAGER_COMPONENTS = DaggerManagerComponents.builder()
                                                            .build();

    public static ManagerComponents getManagerComponents() {
        return MANAGER_COMPONENTS;
    }
}