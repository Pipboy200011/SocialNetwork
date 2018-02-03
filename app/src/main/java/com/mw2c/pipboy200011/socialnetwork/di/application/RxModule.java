package com.mw2c.pipboy200011.socialnetwork.di.application;

import com.mw2c.pipboy200011.socialnetwork.utils.rx.IRxSchedulersUtils;
import com.mw2c.pipboy200011.socialnetwork.utils.rx.RxSchedulersUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

@Module
public class RxModule {

    @Provides
    @Singleton
    public IRxSchedulersUtils provideRxSchedulersUtils() {
        return new RxSchedulersUtils();
    }
}
