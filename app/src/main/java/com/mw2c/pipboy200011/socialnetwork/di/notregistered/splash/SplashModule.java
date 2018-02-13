package com.mw2c.pipboy200011.socialnetwork.di.notregistered.splash;

import com.mw2c.pipboy200011.socialnetwork.data.repository.ISplashRepository;
import com.mw2c.pipboy200011.socialnetwork.data.repository.SplashRepository;
import com.mw2c.pipboy200011.socialnetwork.domain.SplashInteractor;
import com.mw2c.pipboy200011.socialnetwork.presentation.presenter.SplashPresenter;
import com.mw2c.pipboy200011.socialnetwork.utils.rx.IRxSchedulersUtils;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */
@Module
public class SplashModule {

    @Provides
    @SplashScope
    ISplashRepository provideSplashRepository() {
        return new SplashRepository();
    }

    @Provides
    @SplashScope
    SplashInteractor provideSplashInteractor(ISplashRepository repository) {
        return new SplashInteractor(repository);
    }

    @Provides
    @SplashScope
    SplashPresenter provideSplashPresenter(SplashInteractor interactor,
                                           IRxSchedulersUtils rxSchedulersUtils) {
        return new SplashPresenter(interactor, rxSchedulersUtils);
    }
}
