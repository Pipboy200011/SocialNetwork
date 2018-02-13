package com.mw2c.pipboy200011.socialnetwork.data.repository;

import com.mw2c.pipboy200011.socialnetwork.data.api.SocialNetworkApi;
import com.mw2c.pipboy200011.socialnetwork.data.entity.SignUp;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Pavel Apanovskiy on 11.02.2018.
 */

public class RegistrationRepository implements IRegistrationRepository {

    private final Retrofit mRetrofit;

    public RegistrationRepository(Retrofit retrofit) {
        mRetrofit = retrofit;
    }

    @Override
    public Single<Response<String>> register(String name,
                                             String surname,
                                             String mail,
                                             String password) {

        SignUp signUp = new SignUp(name, surname, mail, password);

        return getApi().register(signUp);
    }

    private SocialNetworkApi getApi() {
        return mRetrofit.create(SocialNetworkApi.class);
    }
}
