package com.mw2c.pipboy200011.socialnetwork;

import android.app.Application;

import com.mw2c.pipboy200011.socialnetwork.di.application.ApplicationComponent;
import com.mw2c.pipboy200011.socialnetwork.di.application.ApplicationModule;
import com.mw2c.pipboy200011.socialnetwork.di.application.DaggerApplicationComponent;
import com.mw2c.pipboy200011.socialnetwork.di.application.NavigationModule;
import com.mw2c.pipboy200011.socialnetwork.di.application.NetworkModule;
import com.mw2c.pipboy200011.socialnetwork.di.application.RxModule;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.NotRegisteredComponent;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.NotRegisteredModule;
import com.mw2c.pipboy200011.socialnetwork.di.registered.RegisteredComponent;
import com.mw2c.pipboy200011.socialnetwork.di.registered.RegisteredModule;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

public class SocialNetwork extends Application {

    private static SocialNetwork sInstance;
    private static ApplicationComponent sApplicationComponent;
    private static NotRegisteredComponent sNotRegisteredComponent;
    private static RegisteredComponent sRegisteredComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(sInstance))
                .rxModule(new RxModule())
                .networkModule(new NetworkModule())
                .navigationModule(new NavigationModule())
                .build();
    }


    public static SocialNetwork getInstance() {
        return sInstance;
    }

    public ApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }

    public NotRegisteredComponent getNotRegisteredComponent() {
        if (sNotRegisteredComponent == null) {
            sNotRegisteredComponent = getApplicationComponent().getNotRegisteredComponent(new NotRegisteredModule());
        }
        return sNotRegisteredComponent;
    }

    public RegisteredComponent getRegisteredComponent() {
        if (sRegisteredComponent == null) {
            sRegisteredComponent = getApplicationComponent().getRegisteredComponent(new RegisteredModule());
        }
        return sRegisteredComponent;
    }
}
