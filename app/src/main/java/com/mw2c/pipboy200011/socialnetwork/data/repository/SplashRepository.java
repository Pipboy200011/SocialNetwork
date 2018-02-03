package com.mw2c.pipboy200011.socialnetwork.data.repository;

import io.reactivex.Single;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

public class SplashRepository implements ISplashRepository {
    @Override
    public Single<Boolean> downloadSomethingImportant() {
        return Single.fromCallable(() -> {
            Thread.sleep(2000);
            return true;
        });
    }
}
