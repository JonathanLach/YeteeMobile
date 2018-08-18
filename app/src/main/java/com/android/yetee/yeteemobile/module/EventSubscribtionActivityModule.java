package com.android.yetee.yeteemobile.module;

import com.android.yetee.yeteemobile.activity.EventSubscribtionsActivity;
import com.android.yetee.yeteemobile.contract.EventSubscribtionsContract;
import com.android.yetee.yeteemobile.presenter.EventSubscribtionsPresenterImpl;
import com.android.yetee.yeteemobile.viewHolder.EventSubscribtionsViewHolder;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class EventSubscribtionActivityModule extends BaseActivityModule {
    @Binds
    public abstract EventSubscribtionsContract.View view(EventSubscribtionsActivity eventsListFragment);

    @Provides
    static EventSubscribtionsViewHolder provideLoginViewHolder(EventSubscribtionsContract.View view) {
        return new EventSubscribtionsViewHolder();
    }

    @Provides
    static EventSubscribtionsContract.Presenter provideMainPresenter(EventSubscribtionsContract.View view) {
        return new EventSubscribtionsPresenterImpl(view, getManagerComponents().getEventManager(), view.getViewHolder());
    }
}
