package com.mw2c.pipboy200011.socialnetwork.di.notregistered.splash;

import com.mw2c.pipboy200011.socialnetwork.presentation.ui.SplashActivity;

import dagger.Subcomponent;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */
@Subcomponent(modules = SplashModule.class)
@SplashScope
public interface SplashComponent {

    @Subcomponent.Builder
    interface Builder {
        SplashComponent.Builder makeSplashModule(SplashModule module);

        SplashComponent build();
    }

    void inject(SplashActivity activity);
}
