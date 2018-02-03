package com.mw2c.pipboy200011.socialnetwork.data.api;

import com.mw2c.pipboy200011.socialnetwork.data.entity.Login;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

public interface SocialNetworkApi {

    String HEADER_LOGIN = "login";

    @GET(HEADER_LOGIN)
    Single<Login> login();
}
