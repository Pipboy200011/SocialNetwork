package com.mw2c.pipboy200011.socialnetwork.data.repository;

import io.reactivex.Single;
import retrofit2.Response;

/**
 * Created by Pavel Apanovskiy on 11.02.2018.
 */

public interface IRegistrationRepository {
    Single<Response<String>> register(String name,
                                      String surname,
                                      String mail,
                                      String password);
}
