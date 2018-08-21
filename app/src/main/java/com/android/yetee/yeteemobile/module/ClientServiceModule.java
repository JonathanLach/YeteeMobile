package com.android.yetee.yeteemobile.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.yetee.yeteemobile.app.YeteeApplication;
import com.android.yetee.yeteemobile.constants.SharedPreferencesConstants;
import com.android.yetee.yeteemobile.dataAccess.ServiceCalls;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = DaoBindingsModule.class)
public class ClientServiceModule {

    private static final String BASE_URL = "http://10.0.2.2:50222/api/";

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
            Request request = chain.request();
            SharedPreferences prefs = YeteeApplication.getYeteeContext().getSharedPreferences(SharedPreferencesConstants.USER_PREFERENCES, Context.MODE_PRIVATE);
            String token = prefs.getString(SharedPreferencesConstants.USER_TOKEN, null);
            if(token != null) {
                request = request.newBuilder()
                        .header("authorization", "bearer " + token).build();
            }
            return chain.proceed(request);
        }).build();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @Singleton
    ServiceCalls provideService(Retrofit retrofit) {
        return retrofit.create(ServiceCalls.class);
    }
}