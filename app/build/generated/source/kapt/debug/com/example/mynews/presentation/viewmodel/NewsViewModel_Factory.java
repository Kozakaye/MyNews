package com.example.mynews.presentation.viewmodel;

import com.example.mynews.data.local.NewsRepository;
import com.example.mynews.data.remote.NewsService;
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
public final class NewsViewModel_Factory implements Factory<NewsViewModel> {
  private final Provider<NewsService> apiServiceProvider;

  private final Provider<NewsRepository> repositoryProvider;

  public NewsViewModel_Factory(Provider<NewsService> apiServiceProvider,
      Provider<NewsRepository> repositoryProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public NewsViewModel get() {
    return newInstance(apiServiceProvider.get(), repositoryProvider.get());
  }

  public static NewsViewModel_Factory create(Provider<NewsService> apiServiceProvider,
      Provider<NewsRepository> repositoryProvider) {
    return new NewsViewModel_Factory(apiServiceProvider, repositoryProvider);
  }

  public static NewsViewModel newInstance(NewsService apiService, NewsRepository repository) {
    return new NewsViewModel(apiService, repository);
  }
}
