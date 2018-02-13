package com.mw2c.pipboy200011.socialnetwork.data.repository;

import io.reactivex.Single;

/**
 * Created by Pavel Apanovskiy on 11.02.2018.
 */

public interface IRegistrationRepository {
    Single<String> register(String name,
                            String surname,
                            String mail,
                            String password);
}
