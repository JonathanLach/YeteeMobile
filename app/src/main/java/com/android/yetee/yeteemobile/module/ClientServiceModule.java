package com.android.yetee.yeteemobile.module;

import com.android.yetee.yeteemobile.dataAccess.ServiceCalls;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = DaoBindingsModule.class)
public class ClientServiceModule {

    private static final String BASE_URL = "http://10.0.3.2:50222/api/";

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @Singleton
    ServiceCalls provideService(Retrofit retrofit) {
        return retrofit.create(ServiceCalls.class);
    }
}