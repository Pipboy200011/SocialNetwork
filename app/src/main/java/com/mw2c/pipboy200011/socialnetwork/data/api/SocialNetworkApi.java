package com.mw2c.pipboy200011.socialnetwork.data.api;

import com.mw2c.pipboy200011.socialnetwork.data.entity.Login;
import com.mw2c.pipboy200011.socialnetwork.data.entity.SignUp;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

public interface SocialNetworkApi {

    String HEADER_LOGIN = "Authorization";
    String HEADER_REGISTRATION = "signUp";

    @GET(HEADER_LOGIN)
    Single<Login> login(@Query("") String login);

    @POST(HEADER_REGISTRATION)
    Single<String> register(@Body SignUp signUp);
}