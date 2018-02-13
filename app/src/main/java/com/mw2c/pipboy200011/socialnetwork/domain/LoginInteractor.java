package com.mw2c.pipboy200011.socialnetwork.domain;

import com.mw2c.pipboy200011.socialnetwork.data.entity.Login;
import com.mw2c.pipboy200011.socialnetwork.data.repository.ILoginRepository;

import io.reactivex.Single;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

public class LoginInteractor {

    private final ILoginRepository mLoginRepository;

    public LoginInteractor(ILoginRepository repository) {
        mLoginRepository = repository;
    }

    public Single<Login> tryToLogin(String mail, String password) {
        return mLoginRepository.tryToLogin(mail, password);
    }
}
