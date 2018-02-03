package com.mw2c.pipboy200011.socialnetwork.di.prelogin.login;

import com.mw2c.pipboy200011.socialnetwork.presentation.ui.LoginActivity;

import dagger.Subcomponent;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */
@Subcomponent(modules = LoginModule.class)
@LoginScope
public interface LoginComponent {

    @Subcomponent.Builder
    interface Builder {
        LoginComponent.Builder makeLoginModule(LoginModule module);

        LoginComponent build();
    }

    void inject(LoginActivity activity);
}