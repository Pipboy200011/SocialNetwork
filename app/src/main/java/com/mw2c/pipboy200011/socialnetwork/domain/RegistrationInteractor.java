package com.mw2c.pipboy200011.socialnetwork.domain;

import com.mw2c.pipboy200011.socialnetwork.data.repository.IRegistrationRepository;

import io.reactivex.Single;

/**
 * Created by Pavel Apanovskiy on 11.02.2018.
 */

public class RegistrationInteractor {

    private final IRegistrationRepository mRegistrationRepository;

    public RegistrationInteractor(IRegistrationRepository repository) {
        mRegistrationRepository = repository;
    }

    public Single<String> register(String name,
                                   String surname,
                                   String mail,
                                   String password) {
        return mRegistrationRepository.register(
                name,
                surname,
                mail,
                password);
    }
}
