package com.yasintanriverdi.core.di.modules

import com.yasintanriverdi.core.BuildConfig
import com.yasintanriverdi.core.network.interceptors.RequestInterceptor
import com.yasintanriverdi.core.network.repositories.MovieRepository
import com.yasintanriverdi.core.network.services.MovieService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Singleton
    @Provides
    fun provideHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        requestInterceptor: RequestInterceptor
    ): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
        if (BuildConfig.DEBUG) {
            clientBuilder.addInterceptor(loggingInterceptor)
        }
        return clientBuilder.build()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder() =
        Retrofit.Builder()
            .baseUrl(BuildConfig.TMDB_API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideMovieService(retrofit: Retrofit) = retrofit.create(MovieService::class.java)

    @Singleton
    @Provides
    fun provideMovieRepository(service: MovieService) = MovieRepository(service)
}