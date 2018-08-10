package com.android.yetee.yeteemobile.module;

import com.android.yetee.yeteemobile.activity.EventDetailsActivity;
import com.android.yetee.yeteemobile.contract.EventDetailsContract;
import com.android.yetee.yeteemobile.presenter.EventDetailsPresenterImpl;
import com.android.yetee.yeteemobile.viewHolder.EventDetailsViewHolder;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import static com.android.yetee.yeteemobile.module.BaseActivityModule.getManagerComponents;

@Module
public abstract class EventDetailsActivityModule {
    @Binds
    public abstract EventDetailsContract.View view(EventDetailsActivity eventsListActivity);

    @Provides
    static EventDetailsViewHolder provideLoginViewHolder(EventDetailsContract.View view) {
        return new EventDetailsViewHolder();
    }

    @Provides
    static EventDetailsContract.Presenter provideMainPresenter(EventDetailsContract.View view) {
        return new EventDetailsPresenterImpl(view, getManagerComponents().getEventManager(), view.getViewHolder());
    }
}