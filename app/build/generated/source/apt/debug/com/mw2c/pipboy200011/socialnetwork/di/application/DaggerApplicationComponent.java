package com.mw2c.pipboy200011.socialnetwork.di.application;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.mw2c.pipboy200011.socialnetwork.data.repository.ILoginRepository;
import com.mw2c.pipboy200011.socialnetwork.data.repository.IRegistrationRepository;
import com.mw2c.pipboy200011.socialnetwork.data.repository.ISplashRepository;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.NotRegisteredComponent;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.NotRegisteredModule;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.login.LoginComponent;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.login.LoginModule;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.login.LoginModule_ProvideLoginInteractorFactory;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.login.LoginModule_ProvideLoginPresenterFactory;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.login.LoginModule_ProvideLoginRepositoryFactory;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.login.LoginModule_ProvideRegistrationInteractorFactory;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.login.LoginModule_ProvideRegistrationPresenterFactory;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.login.LoginModule_ProvideRegistrationRepositoryFactory;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.splash.SplashComponent;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.splash.SplashModule;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.splash.SplashModule_ProvideSplashInteractorFactory;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.splash.SplashModule_ProvideSplashPresenterFactory;
import com.mw2c.pipboy200011.socialnetwork.di.notregistered.splash.SplashModule_ProvideSplashRepositoryFactory;
import com.mw2c.pipboy200011.socialnetwork.di.registered.RegisteredComponent;
import com.mw2c.pipboy200011.socialnetwork.di.registered.RegisteredModule;
import com.mw2c.pipboy200011.socialnetwork.di.registered.posts.PostsComponent;
import com.mw2c.pipboy200011.socialnetwork.di.registered.posts.PostsModule;
import com.mw2c.pipboy200011.socialnetwork.domain.LoginInteractor;
import com.mw2c.pipboy200011.socialnetwork.domain.RegistrationInteractor;
import com.mw2c.pipboy200011.socialnetwork.domain.SplashInteractor;
import com.mw2c.pipboy200011.socialnetwork.presentation.presenter.LoginPresenter;
import com.mw2c.pipboy200011.socialnetwork.presentation.presenter.RegistrationPresenter;
import com.mw2c.pipboy200011.socialnetwork.presentation.presenter.SplashPresenter;
import com.mw2c.pipboy200011.socialnetwork.presentation.ui.LoginActivity;
import com.mw2c.pipboy200011.socialnetwork.presentation.ui.LoginActivity_MembersInjector;
import com.mw2c.pipboy200011.socialnetwork.presentation.ui.LoginFragment;
import com.mw2c.pipboy200011.socialnetwork.presentation.ui.LoginFragment_MembersInjector;
import com.mw2c.pipboy200011.socialnetwork.presentation.ui.MainActivity;
import com.mw2c.pipboy200011.socialnetwork.presentation.ui.MainActivity_MembersInjector;
import com.mw2c.pipboy200011.socialnetwork.presentation.ui.PostsFragment;
import com.mw2c.pipboy200011.socialnetwork.presentation.ui.RegistrationFragment;
import com.mw2c.pipboy200011.socialnetwork.presentation.ui.RegistrationFragment_MembersInjector;
import com.mw2c.pipboy200011.socialnetwork.presentation.ui.SplashActivity;
import com.mw2c.pipboy200011.socialnetwork.presentation.ui.SplashActivity_MembersInjector;
import com.mw2c.pipboy200011.socialnetwork.utils.rx.IRxSchedulersUtils;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<IRxSchedulersUtils> provideRxSchedulersUtilsProvider;

  private Provider<NavigatorHolder> provideNavigatorHolderProvider;

  private Provider<Retrofit> provideRetrofitProvider;

  private Provider<Router> provideRouterProvider;

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
    this.provideNavigatorHolderProvider =
        DoubleCheck.provider(
            NavigationModule_ProvideNavigatorHolderFactory.create(builder.navigationModule));
    this.provideRetrofitProvider =
        DoubleCheck.provider(NetworkModule_ProvideRetrofitFactory.create(builder.networkModule));
    this.provideRouterProvider =
        DoubleCheck.provider(
            NavigationModule_ProvideRouterFactory.create(builder.navigationModule));
  }

  @Override
  public NotRegisteredComponent getNotRegisteredComponent(NotRegisteredModule notRegisteredModule) {
    return new NotRegisteredComponentImpl(notRegisteredModule);
  }

  @Override
  public RegisteredComponent getRegisteredComponent(RegisteredModule registeredModule) {
    return new RegisteredComponentImpl(registeredModule);
  }

  public static final class Builder {
    private RxModule rxModule;

    private NavigationModule navigationModule;

    private NetworkModule networkModule;

    private Builder() {}

    public ApplicationComponent build() {
      if (rxModule == null) {
        this.rxModule = new RxModule();
      }
      if (navigationModule == null) {
        this.navigationModule = new NavigationModule();
      }
      if (networkModule == null) {
        this.networkModule = new NetworkModule();
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

    public Builder networkModule(NetworkModule networkModule) {
      this.networkModule = Preconditions.checkNotNull(networkModule);
      return this;
    }

    public Builder navigationModule(NavigationModule navigationModule) {
      this.navigationModule = Preconditions.checkNotNull(navigationModule);
      return this;
    }
  }

  private final class NotRegisteredComponentImpl implements NotRegisteredComponent {
    private final NotRegisteredModule notRegisteredModule;

    private NotRegisteredComponentImpl(NotRegisteredModule notRegisteredModule) {
      this.notRegisteredModule = Preconditions.checkNotNull(notRegisteredModule);
    }

    @Override
    public SplashComponent.Builder getSplashComponentBuilder() {
      return new SplashComponentBuilder();
    }

    @Override
    public LoginComponent.Builder getLoginComponentBuilder() {
      return new LoginComponentBuilder();
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

      private Provider<SplashPresenter> provideSplashPresenterProvider;

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

    private final class LoginComponentBuilder implements LoginComponent.Builder {
      private LoginModule loginModule;

      @Override
      public LoginComponent build() {
        if (loginModule == null) {
          this.loginModule = new LoginModule();
        }
        return new LoginComponentImpl(this);
      }

      @Override
      public LoginComponentBuilder makeLoginModule(LoginModule module) {
        this.loginModule = Preconditions.checkNotNull(module);
        return this;
      }
    }

    private final class LoginComponentImpl implements LoginComponent {
      private Provider<ILoginRepository> provideLoginRepositoryProvider;

      private Provider<LoginInteractor> provideLoginInteractorProvider;

      private Provider<LoginPresenter> provideLoginPresenterProvider;

      private Provider<IRegistrationRepository> provideRegistrationRepositoryProvider;

      private Provider<RegistrationInteractor> provideRegistrationInteractorProvider;

      private Provider<RegistrationPresenter> provideRegistrationPresenterProvider;

      private LoginComponentImpl(LoginComponentBuilder builder) {
        initialize(builder);
      }

      @SuppressWarnings("unchecked")
      private void initialize(final LoginComponentBuilder builder) {
        this.provideLoginRepositoryProvider =
            DoubleCheck.provider(
                LoginModule_ProvideLoginRepositoryFactory.create(
                    builder.loginModule, DaggerApplicationComponent.this.provideRetrofitProvider));
        this.provideLoginInteractorProvider =
            DoubleCheck.provider(
                LoginModule_ProvideLoginInteractorFactory.create(
                    builder.loginModule, provideLoginRepositoryProvider));
        this.provideLoginPresenterProvider =
            DoubleCheck.provider(
                LoginModule_ProvideLoginPresenterFactory.create(
                    builder.loginModule,
                    provideLoginInteractorProvider,
                    DaggerApplicationComponent.this.provideRxSchedulersUtilsProvider,
                    DaggerApplicationComponent.this.provideRouterProvider));
        this.provideRegistrationRepositoryProvider =
            DoubleCheck.provider(
                LoginModule_ProvideRegistrationRepositoryFactory.create(
                    builder.loginModule, DaggerApplicationComponent.this.provideRetrofitProvider));
        this.provideRegistrationInteractorProvider =
            DoubleCheck.provider(
                LoginModule_ProvideRegistrationInteractorFactory.create(
                    builder.loginModule, provideRegistrationRepositoryProvider));
        this.provideRegistrationPresenterProvider =
            DoubleCheck.provider(
                LoginModule_ProvideRegistrationPresenterFactory.create(
                    builder.loginModule,
                    provideRegistrationInteractorProvider,
                    DaggerApplicationComponent.this.provideRxSchedulersUtilsProvider,
                    DaggerApplicationComponent.this.provideRouterProvider));
      }

      @Override
      public void inject(LoginActivity activity) {
        injectLoginActivity(activity);
      }

      @Override
      public void inject(LoginFragment fragment) {
        injectLoginFragment(fragment);
      }

      @Override
      public void inject(RegistrationFragment fragment) {
        injectRegistrationFragment(fragment);
      }

      @CanIgnoreReturnValue
      private LoginActivity injectLoginActivity(LoginActivity instance) {
        LoginActivity_MembersInjector.injectMNavigatorHolder(
            instance, DaggerApplicationComponent.this.provideNavigatorHolderProvider.get());
        return instance;
      }

      @CanIgnoreReturnValue
      private LoginFragment injectLoginFragment(LoginFragment instance) {
        LoginFragment_MembersInjector.injectMLoginPresenter(
            instance, provideLoginPresenterProvider.get());
        return instance;
      }

      @CanIgnoreReturnValue
      private RegistrationFragment injectRegistrationFragment(RegistrationFragment instance) {
        RegistrationFragment_MembersInjector.injectMRegistrationPresenter(
            instance, provideRegistrationPresenterProvider.get());
        return instance;
      }
    }
  }

  private final class RegisteredComponentImpl implements RegisteredComponent {
    private final RegisteredModule registeredModule;

    private RegisteredComponentImpl(RegisteredModule registeredModule) {
      this.registeredModule = Preconditions.checkNotNull(registeredModule);
    }

    @Override
    public PostsComponent.Builder getPostsComponentBuilder() {
      return new PostsComponentBuilder();
    }

    private final class PostsComponentBuilder implements PostsComponent.Builder {
      @Override
      public PostsComponent build() {
        return new PostsComponentImpl(this);
      }

      /**
       * This module is declared, but an instance is not used in the component. This method is a
       * no-op. For more, see https://google.github.io/dagger/unused-modules.
       */
      @Override
      public PostsComponentBuilder makePostsModule(PostsModule module) {
        return this;
      }
    }

    private final class PostsComponentImpl implements PostsComponent {
      private PostsComponentImpl(PostsComponentBuilder builder) {}

      @Override
      public void inject(MainActivity mainActivity) {
        injectMainActivity(mainActivity);
      }

      @Override
      public void inject(PostsFragment fragment) {}

      @CanIgnoreReturnValue
      private MainActivity injectMainActivity(MainActivity instance) {
        MainActivity_MembersInjector.injectMNavigatorHolder(
            instance, DaggerApplicationComponent.this.provideNavigatorHolderProvider.get());
        MainActivity_MembersInjector.injectMRouter(
            instance, DaggerApplicationComponent.this.provideRouterProvider.get());
        return instance;
      }
    }
  }
}
