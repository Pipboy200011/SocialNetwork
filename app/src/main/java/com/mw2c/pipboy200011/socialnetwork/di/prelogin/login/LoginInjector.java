package com.mw2c.pipboy200011.socialnetwork.di.prelogin.login;

import com.mw2c.pipboy200011.socialnetwork.SocialNetwork;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

public class LoginInjector {

    private static LoginComponent sLoginComponent;

    public static LoginComponent getLoginComponent() {
        if (sLoginComponent == null) {
            sLoginComponent = SocialNetwork.getInstance()
                    .getPreLoginComponent()
                    .getLoginComponentBuilder()
                    .makeLoginModule(new LoginModule())
                    .build();
        }
        return sLoginComponent;
    }

    public static void clearLoginComponent() {
        sLoginComponent = null;
    }
}