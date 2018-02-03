package com.mw2c.pipboy200011.socialnetwork.di.prelogin.splash;

import com.mw2c.pipboy200011.socialnetwork.data.repository.ISplashRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SplashModule_ProvideSplashRepositoryFactory
    implements Factory<ISplashRepository> {
  private final SplashModule module;

  public SplashModule_ProvideSplashRepositoryFactory(SplashModule module) {
    this.module = module;
  }

  @Override
  public ISplashRepository get() {
    return Preconditions.checkNotNull(
        module.provideSplashRepository(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<ISplashRepository> create(SplashModule module) {
    return new SplashModule_ProvideSplashRepositoryFactory(module);
  }

  public static ISplashRepository proxyProvideSplashRepository(SplashModule instance) {
    return instance.provideSplashRepository();
  }
}
