package com.mw2c.pipboy200011.socialnetwork.di;

import com.mw2c.pipboy200011.socialnetwork.utils.rx.IRxSchedulersUtils;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RxModule_ProvideRxSchedulersUtilsFactory implements Factory<IRxSchedulersUtils> {
  private final RxModule module;

  public RxModule_ProvideRxSchedulersUtilsFactory(RxModule module) {
    this.module = module;
  }

  @Override
  public IRxSchedulersUtils get() {
    return Preconditions.checkNotNull(
        module.provideRxSchedulersUtils(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<IRxSchedulersUtils> create(RxModule module) {
    return new RxModule_ProvideRxSchedulersUtilsFactory(module);
  }
}
