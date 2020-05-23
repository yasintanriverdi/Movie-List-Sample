package com.yasintanriverdi.movielistsample.di

import com.yasintanriverdi.core.di.CoreComponent
import com.yasintanriverdi.core.di.scopes.AppScope
import com.yasintanriverdi.movielistsample.MovieListApplication
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {

    fun inject(application: MovieListApplication)
}