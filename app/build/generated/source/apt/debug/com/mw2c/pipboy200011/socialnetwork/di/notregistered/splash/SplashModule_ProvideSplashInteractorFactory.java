package com.mw2c.pipboy200011.socialnetwork.di.notregistered.splash;

import com.mw2c.pipboy200011.socialnetwork.data.repository.ISplashRepository;
import com.mw2c.pipboy200011.socialnetwork.domain.SplashInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SplashModule_ProvideSplashInteractorFactory
    implements Factory<SplashInteractor> {
  private final SplashModule module;

  private final Provider<ISplashRepository> repositoryProvider;

  public SplashModule_ProvideSplashInteractorFactory(
      SplashModule module, Provider<ISplashRepository> repositoryProvider) {
    this.module = module;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SplashInteractor get() {
    return Preconditions.checkNotNull(
        module.provideSplashInteractor(repositoryProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<SplashInteractor> create(
      SplashModule module, Provider<ISplashRepository> repositoryProvider) {
    return new SplashModule_ProvideSplashInteractorFactory(module, repositoryProvider);
  }

  public static SplashInteractor proxyProvideSplashInteractor(
      SplashModule instance, ISplashRepository repository) {
    return instance.provideSplashInteractor(repository);
  }
}
