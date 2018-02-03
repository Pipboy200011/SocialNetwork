package com.mw2c.pipboy200011.socialnetwork.domain;

import com.mw2c.pipboy200011.socialnetwork.data.repository.ISplashRepository;

import io.reactivex.Single;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

public class SplashInteractor {

    private final ISplashRepository mSplashRepository;

    public SplashInteractor(ISplashRepository splashRepository) {
        mSplashRepository = splashRepository;
    }

    public Single<Boolean> downloadSomethingImportant() {
        return mSplashRepository.downloadSomethingImportant();
    }
}
