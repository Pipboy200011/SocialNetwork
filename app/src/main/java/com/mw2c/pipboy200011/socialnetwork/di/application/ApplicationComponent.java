package com.mw2c.pipboy200011.socialnetwork.di.application;

import com.mw2c.pipboy200011.socialnetwork.di.prelogin.PreLoginComponent;
import com.mw2c.pipboy200011.socialnetwork.di.prelogin.PreLoginModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Pavel Apanovskiy on 19.11.2017.
 */

@Component(modules = {ApplicationModule.class, RxModule.class, NetworkModule.class, NavigationModule.class})
@Singleton
public interface ApplicationComponent {

    PreLoginComponent getPreLoginComponent(PreLoginModule preLoginModule);

}
