package com.android.yetee.yeteemobile.module;

import com.android.yetee.yeteemobile.contract.EventsListContract;
import com.android.yetee.yeteemobile.fragment.EventsListFragment;
import com.android.yetee.yeteemobile.presenter.EventsListPresenterImpl;
import com.android.yetee.yeteemobile.viewHolder.EventsListViewHolder;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import static com.android.yetee.yeteemobile.module.BaseActivityModule.getManagerComponents;

@Module
public abstract class EventsListActivityModule {
    @Binds
    public abstract EventsListContract.View view(EventsListFragment eventsListFragment);

    @Provides
    static EventsListViewHolder provideLoginViewHolder(EventsListContract.View view) {
        return new EventsListViewHolder();
    }

    @Provides
    static EventsListContract.Presenter provideMainPresenter(EventsListContract.View view) {
        return new EventsListPresenterImpl(view, getManagerComponents().getEventManager(), view.getViewHolder());
    }
}
