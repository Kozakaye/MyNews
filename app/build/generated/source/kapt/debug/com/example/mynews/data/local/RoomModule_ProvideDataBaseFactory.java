package com.example.mynews.data.local;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class RoomModule_ProvideDataBaseFactory implements Factory<NewsDatabase> {
  private final Provider<Context> contextProvider;

  public RoomModule_ProvideDataBaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NewsDatabase get() {
    return provideDataBase(contextProvider.get());
  }

  public static RoomModule_ProvideDataBaseFactory create(Provider<Context> contextProvider) {
    return new RoomModule_ProvideDataBaseFactory(contextProvider);
  }

  public static NewsDatabase provideDataBase(Context context) {
    return Preconditions.checkNotNullFromProvides(RoomModule.INSTANCE.provideDataBase(context));
  }
}
