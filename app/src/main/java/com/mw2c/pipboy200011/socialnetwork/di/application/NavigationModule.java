package com.mw2c.pipboy200011.socialnetwork.di.application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

/**
 * Created by Pavel Apanovskiy on 09.02.2018.
 */
@Module
public class NavigationModule {

    private Cicerone<Router> mCicerone;

    public NavigationModule() {
        mCicerone = Cicerone.create();
    }

    @Provides
    @Singleton
    Router provideRouter() {
        return mCicerone.getRouter();
    }

    @Provides
    @Singleton
    NavigatorHolder provideNavigatorHolder() {
        return mCicerone.getNavigatorHolder();
    }
}
