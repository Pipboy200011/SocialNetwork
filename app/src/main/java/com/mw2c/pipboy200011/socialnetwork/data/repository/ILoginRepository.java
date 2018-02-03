package com.mw2c.pipboy200011.socialnetwork.data.repository;

import com.mw2c.pipboy200011.socialnetwork.data.entity.Login;

import io.reactivex.Single;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

public interface ILoginRepository {
    Single<Login> tryToLogin(String mail, String password);

}
