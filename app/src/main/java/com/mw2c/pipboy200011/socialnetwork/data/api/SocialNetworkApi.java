package com.mw2c.pipboy200011.socialnetwork.data.api;

import com.mw2c.pipboy200011.socialnetwork.data.entity.Login;
import com.mw2c.pipboy200011.socialnetwork.data.entity.SignUp;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

public interface SocialNetworkApi {

    String HEADER_LOGIN = "login";
    String HEADER_REGISTRATION = "signUp";

    @Headers("Content-Type: application/json")
    @GET(HEADER_LOGIN)
    Single<Login> login(@Header("Authorization") String login);

    @POST(HEADER_REGISTRATION)
    Single<Response<String>> register(@Body SignUp signUp);
}