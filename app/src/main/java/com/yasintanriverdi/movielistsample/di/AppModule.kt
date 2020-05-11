package com.yasintanriverdi.movielistsample.di

import android.content.Context
import com.yasintanriverdi.movielistsample.MovieListApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(application: MovieListApplication): Context = application.applicationContext
}