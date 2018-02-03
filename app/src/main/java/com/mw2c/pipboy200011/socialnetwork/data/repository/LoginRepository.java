package com.mw2c.pipboy200011.socialnetwork.data.repository;

import com.mw2c.pipboy200011.socialnetwork.data.api.SocialNetworkApi;
import com.mw2c.pipboy200011.socialnetwork.data.entity.Login;

import io.reactivex.Single;
import retrofit2.Retrofit;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

public class LoginRepository implements ILoginRepository {


    private final Retrofit mRetrofit;

    public LoginRepository(Retrofit retrofit) {
        mRetrofit = retrofit;
    }

    @Override
    public Single<Login> tryToLogin(String mail, String password) {
        return getApi().login();
    }

    private SocialNetworkApi getApi() {
        return mRetrofit.create(SocialNetworkApi.class);
    }
}
