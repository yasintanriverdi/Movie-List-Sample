package com.yasintanriverdi.moviedetail.di

import com.yasintanriverdi.commons.extensions.viewModel
import com.yasintanriverdi.core.di.scopes.FeatureScope
import com.yasintanriverdi.core.repositories.MovieRepository
import com.yasintanriverdi.moviedetail.MovieDetailFragment
import com.yasintanriverdi.moviedetail.MovieDetailViewModel
import dagger.Module
import dagger.Provides

@Module
class MovieDetailModule(private val movieDetailFragment: MovieDetailFragment) {

    @Provides
    @FeatureScope
    fun provideViewModel(
        movieRepository: MovieRepository
    ) = movieDetailFragment.viewModel {
        MovieDetailViewModel(movieRepository)
    }
}