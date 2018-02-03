package com.mw2c.pipboy200011.socialnetwork.di.application;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.mw2c.pipboy200011.socialnetwork.data.repository.ISplashRepository;
import com.mw2c.pipboy200011.socialnetwork.di.RxModule;
import com.mw2c.pipboy200011.socialnetwork.di.RxModule_ProvideRxSchedulersUtilsFactory;
import com.mw2c.pipboy200011.socialnetwork.di.prelogin.PreLoginComponent;
import com.mw2c.pipboy200011.socialnetwork.di.prelogin.PreLoginModule;
import com.mw2c.pipboy200011.socialnetwork.di.prelogin.splash.SplashComponent;
import com.mw2c.pipboy200011.socialnetwork.di.prelogin.splash.SplashModule;
import com.mw2c.pipboy200011.socialnetwork.di.prelogin.splash.SplashModule_ProvideSplashInteractorFactory;
import com.mw2c.pipboy200011.socialnetwork.di.prelogin.splash.SplashModule_ProvideSplashPresenterFactory;
import com.mw2c.pipboy200011.socialnetwork.di.prelogin.splash.SplashModule_ProvideSplashRepositoryFactory;
import com.mw2c.pipboy200011.socialnetwork.domain.SplashInteractor;
import com.mw2c.pipboy200011.socialnetwork.presentation.presenter.ISplashPresenter;
import com.mw2c.pipboy200011.socialnetwork.presentation.ui.SplashActivity;
import com.mw2c.pipboy200011.socialnetwork.presentation.ui.SplashActivity_MembersInjector;
import com.mw2c.pipboy200011.socialnetwork.utils.rx.IRxSchedulersUtils;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<IRxSchedulersUtils> provideRxSchedulersUtilsProvider;

  private DaggerApplicationComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static ApplicationComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideRxSchedulersUtilsProvider =
        DoubleCheck.provider(RxModule_ProvideRxSchedulersUtilsFactory.create(builder.rxModule));
  }

  @Override
  public PreLoginComponent getPreLoginComponent(PreLoginModule preLoginModule) {
    return new PreLoginComponentImpl(preLoginModule);
  }

  public static final class Builder {
    private RxModule rxModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (rxModule == null) {
        this.rxModule = new RxModule();
      }
      return new DaggerApplicationComponent(this);
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This
     *     method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Deprecated
    public Builder applicationModule(ApplicationModule applicationModule) {
      Preconditions.checkNotNull(applicationModule);
      return this;
    }

    public Builder rxModule(RxModule rxModule) {
      this.rxModule = Preconditions.checkNotNull(rxModule);
      return this;
    }
  }

  private final class PreLoginComponentImpl implements PreLoginComponent {
    private final PreLoginModule preLoginModule;

    private PreLoginComponentImpl(PreLoginModule preLoginModule) {
      this.preLoginModule = Preconditions.checkNotNull(preLoginModule);
    }

    @Override
    public SplashComponent.Builder getSplashComponentBuilder() {
      return new SplashComponentBuilder();
    }

    private final class SplashComponentBuilder implements SplashComponent.Builder {
      private SplashModule splashModule;

      @Override
      public SplashComponent build() {
        if (splashModule == null) {
          this.splashModule = new SplashModule();
        }
        return new SplashComponentImpl(this);
      }

      @Override
      public SplashComponentBuilder makeSplashModule(SplashModule module) {
        this.splashModule = Preconditions.checkNotNull(module);
        return this;
      }
    }

    private final class SplashComponentImpl implements SplashComponent {
      private Provider<ISplashRepository> provideSplashRepositoryProvider;

      private Provider<SplashInteractor> provideSplashInteractorProvider;

      private Provider<ISplashPresenter> provideSplashPresenterProvider;

      private SplashComponentImpl(SplashComponentBuilder builder) {
        initialize(builder);
      }

      @SuppressWarnings("unchecked")
      private void initialize(final SplashComponentBuilder builder) {
        this.provideSplashRepositoryProvider =
            DoubleCheck.provider(
                SplashModule_ProvideSplashRepositoryFactory.create(builder.splashModule));
        this.provideSplashInteractorProvider =
            DoubleCheck.provider(
                SplashModule_ProvideSplashInteractorFactory.create(
                    builder.splashModule, provideSplashRepositoryProvider));
        this.provideSplashPresenterProvider =
            DoubleCheck.provider(
                SplashModule_ProvideSplashPresenterFactory.create(
                    builder.splashModule,
                    provideSplashInteractorProvider,
                    DaggerApplicationComponent.this.provideRxSchedulersUtilsProvider));
      }

      @Override
      public void inject(SplashActivity activity) {
        injectSplashActivity(activity);
      }

      @CanIgnoreReturnValue
      private SplashActivity injectSplashActivity(SplashActivity instance) {
        SplashActivity_MembersInjector.injectMSplashPresenter(
            instance, provideSplashPresenterProvider.get());
        return instance;
      }
    }
  }
}
