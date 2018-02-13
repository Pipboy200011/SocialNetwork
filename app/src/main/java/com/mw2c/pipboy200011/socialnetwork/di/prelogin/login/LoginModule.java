package com.mw2c.pipboy200011.socialnetwork.di.prelogin.login;

import com.mw2c.pipboy200011.socialnetwork.data.repository.ILoginRepository;
import com.mw2c.pipboy200011.socialnetwork.data.repository.IRegistrationRepository;
import com.mw2c.pipboy200011.socialnetwork.data.repository.LoginRepository;
import com.mw2c.pipboy200011.socialnetwork.data.repository.RegistrationRepository;
import com.mw2c.pipboy200011.socialnetwork.domain.LoginInteractor;
import com.mw2c.pipboy200011.socialnetwork.domain.RegistrationInteractor;
import com.mw2c.pipboy200011.socialnetwork.presentation.presenter.LoginPresenter;
import com.mw2c.pipboy200011.socialnetwork.presentation.presenter.RegistrationPresenter;
import com.mw2c.pipboy200011.socialnetwork.utils.rx.IRxSchedulersUtils;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import ru.terrakok.cicerone.Router;

/**
 * Created by Pavel Apanovskiy on 03.02.2018.
 */
@Module
public class LoginModule {

    @Provides
    @LoginScope
    ILoginRepository provideLoginRepository(Retrofit retrofit) {
        return new LoginRepository(retrofit);
    }

    @Provides
    @LoginScope
    LoginInteractor provideLoginInteractor(ILoginRepository repository) {
        return new LoginInteractor(repository);
    }

    @Provides
    @LoginScope
    LoginPresenter provideLoginPresenter(LoginInteractor interactor,
                                         IRxSchedulersUtils rxSchedulersUtils,
                                         Router router) {
        return new LoginPresenter(interactor, rxSchedulersUtils, router);
    }

    @Provides
    @LoginScope
    IRegistrationRepository provideRegistrationRepository(Retrofit retrofit) {
        return new RegistrationRepository(retrofit);
    }

    @Provides
    @LoginScope
    RegistrationInteractor provideRegistrationInteractor(IRegistrationRepository repository) {
        return new RegistrationInteractor(repository);
    }

    @Provides
    @LoginScope
    RegistrationPresenter provideRegistrationPresenter(RegistrationInteractor interactor,
                                                       IRxSchedulersUtils rxSchedulersUtils,
                                                       Router router) {
        return new RegistrationPresenter(interactor, rxSchedulersUtils, router);
    }
}
