package com.example.mynews.data.local;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class NewsRepository_Factory implements Factory<NewsRepository> {
  private final Provider<NewsDAO> newsDAOProvider;

  public NewsRepository_Factory(Provider<NewsDAO> newsDAOProvider) {
    this.newsDAOProvider = newsDAOProvider;
  }

  @Override
  public NewsRepository get() {
    return newInstance(newsDAOProvider.get());
  }

  public static NewsRepository_Factory create(Provider<NewsDAO> newsDAOProvider) {
    return new NewsRepository_Factory(newsDAOProvider);
  }

  public static NewsRepository newInstance(NewsDAO newsDAO) {
    return new NewsRepository(newsDAO);
  }
}
