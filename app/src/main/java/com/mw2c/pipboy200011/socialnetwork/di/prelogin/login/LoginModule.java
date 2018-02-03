package com.mw2c.pipboy200011.socialnetwork.di.prelogin.login;

import com.mw2c.pipboy200011.socialnetwork.data.repository.ILoginRepository;
import com.mw2c.pipboy200011.socialnetwork.data.repository.LoginRepository;
import com.mw2c.pipboy200011.socialnetwork.domain.LoginInteractor;
import com.mw2c.pipboy200011.socialnetwork.presentation.presenter.LoginPresenter;
import com.mw2c.pipboy200011.socialnetwork.utils.rx.IRxSchedulersUtils;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

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
                                         IRxSchedulersUtils rxSchedulersUtils) {
        return new LoginPresenter(interactor, rxSchedulersUtils);
    }
}
