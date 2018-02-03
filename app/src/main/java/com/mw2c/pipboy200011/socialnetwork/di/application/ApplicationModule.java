package com.mw2c.pipboy200011.socialnetwork.di.application;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pavel Apanovskiy on 19.11.2017.
 */

@Module
public class ApplicationModule {

    private final Context mContext;

    public ApplicationModule(@NonNull Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mContext;
    }
}
