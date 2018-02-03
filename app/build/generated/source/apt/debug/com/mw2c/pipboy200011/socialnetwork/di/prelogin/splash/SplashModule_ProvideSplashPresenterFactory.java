package com.mw2c.pipboy200011.socialnetwork.di.prelogin.splash;

import com.mw2c.pipboy200011.socialnetwork.domain.SplashInteractor;
import com.mw2c.pipboy200011.socialnetwork.presentation.presenter.ISplashPresenter;
import com.mw2c.pipboy200011.socialnetwork.utils.rx.IRxSchedulersUtils;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SplashModule_ProvideSplashPresenterFactory implements Factory<ISplashPresenter> {
  private final SplashModule module;

  private final Provider<SplashInteractor> interactorProvider;

  private final Provider<IRxSchedulersUtils> rxSchedulersUtilsProvider;

  public SplashModule_ProvideSplashPresenterFactory(
      SplashModule module,
      Provider<SplashInteractor> interactorProvider,
      Provider<IRxSchedulersUtils> rxSchedulersUtilsProvider) {
    this.module = module;
    this.interactorProvider = interactorProvider;
    this.rxSchedulersUtilsProvider = rxSchedulersUtilsProvider;
  }

  @Override
  public ISplashPresenter get() {
    return Preconditions.checkNotNull(
        module.provideSplashPresenter(interactorProvider.get(), rxSchedulersUtilsProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ISplashPresenter> create(
      SplashModule module,
      Provider<SplashInteractor> interactorProvider,
      Provider<IRxSchedulersUtils> rxSchedulersUtilsProvider) {
    return new SplashModule_ProvideSplashPresenterFactory(
        module, interactorProvider, rxSchedulersUtilsProvider);
  }

  public static ISplashPresenter proxyProvideSplashPresenter(
      SplashModule instance, SplashInteractor interactor, IRxSchedulersUtils rxSchedulersUtils) {
    return instance.provideSplashPresenter(interactor, rxSchedulersUtils);
  }
}
