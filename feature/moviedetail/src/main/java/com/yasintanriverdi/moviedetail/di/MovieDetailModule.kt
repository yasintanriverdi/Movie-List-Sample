package com.yasintanriverdi.moviedetail.di

import com.yasintanriverdi.commons.extensions.viewModel
import com.yasintanriverdi.core.di.scopes.FeatureScope
import com.yasintanriverdi.moviedetail.MovieDetailFragment
import com.yasintanriverdi.moviedetail.MovieDetailViewModel
import com.yasintanriverdi.moviedetail.usecases.FetchMovieUseCase
import dagger.Module
import dagger.Provides

@Module
class MovieDetailModule(private val movieDetailFragment: MovieDetailFragment) {

    @Provides
    @FeatureScope
    fun provideViewModel(
        fetchMovieUseCase: FetchMovieUseCase
    ) = movieDetailFragment.viewModel {
        MovieDetailViewModel(fetchMovieUseCase)
    }

}