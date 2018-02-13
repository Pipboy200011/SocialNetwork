package com.mw2c.pipboy200011.socialnetwork.di.notregistered;

import com.mw2c.pipboy200011.socialnetwork.di.notregistered.login.LoginComponent;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.splash.SplashComponent;

import dagger.Subcomponent;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

@Subcomponent(modules = NotRegisteredModule.class)
@NotRegisteredScope
public interface NotRegisteredComponent {

    SplashComponent.Builder getSplashComponentBuilder();

    LoginComponent.Builder getLoginComponentBuilder();
}
