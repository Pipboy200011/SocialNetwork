package com.mw2c.pipboy200011.socialnetwork.di.application;

import com.mw2c.pipboy200011.socialnetwork.di.notregistered.NotRegisteredComponent;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.NotRegisteredModule;
import com.mw2c.pipboy200011.socialnetwork.di.registered.RegisteredComponent;
import com.mw2c.pipboy200011.socialnetwork.di.registered.RegisteredModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Pavel Apanovskiy on 19.11.2017.
 */

@Component(modules = {ApplicationModule.class, RxModule.class, NetworkModule.class, NavigationModule.class})
@Singleton
public interface ApplicationComponent {

    NotRegisteredComponent getNotRegisteredComponent(NotRegisteredModule notRegisteredModule);

    RegisteredComponent getRegisteredComponent(RegisteredModule registeredModule);
}
