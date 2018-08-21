package com.android.yetee.yeteemobile.dataAccess;

import com.android.yetee.yeteemobile.model.Event;
import com.android.yetee.yeteemobile.model.IdFilter;
import com.android.yetee.yeteemobile.model.PointOfInterest;
import com.android.yetee.yeteemobile.model.Token;
import com.android.yetee.yeteemobile.model.TokenRequest;
import com.android.yetee.yeteemobile.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ServiceCalls {
    @GET("users/login/{username}")
    Call<User> login(@Path("username")String username, @Header("password")String password);

    @GET("pointsOfInterest")
    Call<List<PointOfInterest>> getAllPointsOfInterest();

    @GET("events")
    Call<List<Event>> getAllEvents();

    @GET("events/id/{id}")
    Call<Event> getEventById(@Path("id")Long id);

    @POST("token")
    Call<Token> getToken(@Body TokenRequest tokenRequest);

    @POST("users")
    Call<Void> register(@Body User u);

    @PUT("events/idList")
    Call<List<Event>> getEventsWithId(@Body List<IdFilter> ids);

    @GET("users/username/{username}")
    Call<User> getUserByUsername(@Path("username")String username);

    @GET("pointsOfInterest/eventid/{id}")
    Call<List<PointOfInterest>> getPointsOfInterestFromEvent(@Path("id")Long id);
}
