package com.android.yetee.yeteemobile.dataAccess;

import com.android.yetee.yeteemobile.model.PointOfInterest;
import com.android.yetee.yeteemobile.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface ServiceCalls {
    @GET("users/username/{username}")
    Call<User> getUserByNickname(@Path("username")String username, @Header("password")String password);

    @GET("pointsOfInterest")
    Call<List<PointOfInterest>> getAllPointsOfInterest();
}
