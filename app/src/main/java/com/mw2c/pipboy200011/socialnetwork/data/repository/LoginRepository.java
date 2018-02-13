package com.mw2c.pipboy200011.socialnetwork.data.repository;

import android.util.Base64;

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

        return getApi().login(getLoginData(mail, password));
    }

    private SocialNetworkApi getApi() {
        return mRetrofit.create(SocialNetworkApi.class);
    }

    private String getLoginData(String mail, String password) {
        byte[] loginByte = (mail + ":" + password).getBytes();
        byte[] encode = Base64.encode(loginByte, Base64.DEFAULT);
        String login = new String(encode);
        return "Basic " + login;
    }

    /*firstName":"qaz","lastName":"qaz","password":"qazqaz","userName":"qaz@qaz.com"}*/
}
