package com.yasintanriverdi.movies.di

import com.yasintanriverdi.core.di.CoreComponent
import com.yasintanriverdi.core.di.scopes.FeatureScope
import dagger.Component
import com.yasintanriverdi.movies.MoviesFragment

@FeatureScope
@Component(
    modules = [MoviesModule::class],
    dependencies = [CoreComponent::class])
interface MoviesComponent {
    fun inject(moviesFragment: MoviesFragment)
}