package com.example.mynews.data.local;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
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
public final class RoomModule_ProvideNewsDaoFactory implements Factory<NewsDAO> {
  private final Provider<NewsDatabase> databaseProvider;

  public RoomModule_ProvideNewsDaoFactory(Provider<NewsDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public NewsDAO get() {
    return provideNewsDao(databaseProvider.get());
  }

  public static RoomModule_ProvideNewsDaoFactory create(Provider<NewsDatabase> databaseProvider) {
    return new RoomModule_ProvideNewsDaoFactory(databaseProvider);
  }

  public static NewsDAO provideNewsDao(NewsDatabase database) {
    return Preconditions.checkNotNullFromProvides(RoomModule.INSTANCE.provideNewsDao(database));
  }
}
