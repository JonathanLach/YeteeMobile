package com.android.yetee.yeteemobile.dataAccess.impl;

import android.app.Service;

import com.android.yetee.yeteemobile.dataAccess.EventDAO;
import com.android.yetee.yeteemobile.dataAccess.ServiceCalls;
import com.android.yetee.yeteemobile.model.Event;
import com.android.yetee.yeteemobile.model.IdFilter;
import com.android.yetee.yeteemobile.util.AsyncCallbackTwoParam;
import com.android.yetee.yeteemobile.util.ConnectionChecker;
import com.android.yetee.yeteemobile.util.ServiceResultState;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventDAOImpl implements EventDAO {

    private ServiceCalls service;

    @Inject
    public EventDAOImpl(ServiceCalls service) {
        this.service = service;
    }

    @Override
    public void getEventById(Long id, AsyncCallbackTwoParam<Event, ServiceResultState> callback) {
        Call<Event> call = service.getEventById(id);
        call.enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {
                callback.apply(response.body(), ServiceResultState.OK);
            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {
                ServiceResultState serviceResultState = ConnectionChecker.checkConnectivity(t);
                callback.apply(null, serviceResultState);
            }
        });
    }

    @Override
    public void getAllEvents(AsyncCallbackTwoParam<List<Event>, ServiceResultState> callback) {
        Call<List<Event>> call = service.getAllEvents();
        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                callback.apply(response.body(), ServiceResultState.OK);
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                ServiceResultState serviceResultState = ConnectionChecker.checkConnectivity(t);
                callback.apply(null, serviceResultState);
            }
        });
    }

    @Override
    public void getSubscribtions(List<IdFilter> eventsId, AsyncCallbackTwoParam<List<Event>, ServiceResultState> callback) {
        Call<List<Event>> call = service.getEventsWithId(eventsId);
        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                callback.apply(response.body(), ServiceResultState.OK);
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                ServiceResultState serviceResultState = ConnectionChecker.checkConnectivity(t);
                callback.apply(null, serviceResultState);
            }
        });
    }
}
