package com.mw2c.pipboy200011.socialnetwork;

import android.app.Application;

import com.mw2c.pipboy200011.socialnetwork.di.RxModule;
import com.mw2c.pipboy200011.socialnetwork.di.application.ApplicationComponent;
import com.mw2c.pipboy200011.socialnetwork.di.application.ApplicationModule;
import com.mw2c.pipboy200011.socialnetwork.di.application.DaggerApplicationComponent;
import com.mw2c.pipboy200011.socialnetwork.di.prelogin.PreLoginComponent;
import com.mw2c.pipboy200011.socialnetwork.di.prelogin.PreLoginModule;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */

public class SocialNetwork extends Application {

    private static SocialNetwork sInstance;
    private static ApplicationComponent sApplicationComponent;
    private static PreLoginComponent sPreLoginComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(sInstance))
                .rxModule(new RxModule())
                .build();
    }


    public static SocialNetwork getInstance() {
        return sInstance;
    }

    public ApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }

    public PreLoginComponent getPreLoginComponent() {
        if (sPreLoginComponent == null) {
            sPreLoginComponent = getApplicationComponent().getPreLoginComponent(new PreLoginModule());
        }
        return sPreLoginComponent;
    }
}
