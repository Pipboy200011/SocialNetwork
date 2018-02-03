package com.mw2c.pipboy200011.socialnetwork.presentation.ui;

import com.mw2c.pipboy200011.socialnetwork.presentation.presenter.SplashPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SplashActivity_MembersInjector implements MembersInjector<SplashActivity> {
  private final Provider<SplashPresenter> mSplashPresenterProvider;

  public SplashActivity_MembersInjector(Provider<SplashPresenter> mSplashPresenterProvider) {
    this.mSplashPresenterProvider = mSplashPresenterProvider;
  }

  public static MembersInjector<SplashActivity> create(
      Provider<SplashPresenter> mSplashPresenterProvider) {
    return new SplashActivity_MembersInjector(mSplashPresenterProvider);
  }

  @Override
  public void injectMembers(SplashActivity instance) {
    injectMSplashPresenter(instance, mSplashPresenterProvider.get());
  }

  public static void injectMSplashPresenter(
      SplashActivity instance, SplashPresenter mSplashPresenter) {
    instance.mSplashPresenter = mSplashPresenter;
  }
}
