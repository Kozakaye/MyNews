package com.example.mynews.data.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
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
public final class RetrofitModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final Provider<String> baseUrlProvider;

  public RetrofitModule_ProvideRetrofitFactory(Provider<String> baseUrlProvider) {
    this.baseUrlProvider = baseUrlProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofit(baseUrlProvider.get());
  }

  public static RetrofitModule_ProvideRetrofitFactory create(Provider<String> baseUrlProvider) {
    return new RetrofitModule_ProvideRetrofitFactory(baseUrlProvider);
  }

  public static Retrofit provideRetrofit(String baseUrl) {
    return Preconditions.checkNotNullFromProvides(RetrofitModule.INSTANCE.provideRetrofit(baseUrl));
  }
}
