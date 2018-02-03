package com.mw2c.pipboy200011.socialnetwork.di.prelogin.splash;

import com.mw2c.pipboy200011.socialnetwork.SocialNetwork;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

public class SplashInjector {

    private static SplashComponent sSplashComponent;

    public static SplashComponent getSplashComponent() {
        if (sSplashComponent == null) {
            sSplashComponent = SocialNetwork.getInstance()
                    .getPreLoginComponent()
                    .getSplashComponentBuilder()
                    .makeSplashModule(new SplashModule())
                    .build();
        }
        return sSplashComponent;
    }

    public static void cancelSplashComponent() {
        sSplashComponent = null;
    }
}
