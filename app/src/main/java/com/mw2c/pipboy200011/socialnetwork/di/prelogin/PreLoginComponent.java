package com.mw2c.pipboy200011.socialnetwork.di.prelogin;

import com.mw2c.pipboy200011.socialnetwork.di.prelogin.splash.SplashComponent;

import dagger.Subcomponent;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

@Subcomponent(modules = PreLoginModule.class)
@PreLoginScope
public interface PreLoginComponent {

    SplashComponent.Builder getSplashComponentBuilder();
}
