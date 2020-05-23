package com.yasintanriverdi.moviedetail.di

import com.yasintanriverdi.core.di.CoreComponent
import com.yasintanriverdi.core.di.scopes.FeatureScope
import com.yasintanriverdi.moviedetail.MovieDetailFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [MovieDetailModule::class],
    dependencies = [CoreComponent::class]
)
interface MovieDetailComponent {
    fun inject(movieDetailFragment: MovieDetailFragment)
}