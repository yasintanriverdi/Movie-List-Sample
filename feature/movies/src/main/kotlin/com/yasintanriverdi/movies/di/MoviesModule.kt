package com.yasintanriverdi.movies.di

import androidx.lifecycle.viewModelScope
import com.yasintanriverdi.commons.extensions.viewModel
import com.yasintanriverdi.core.di.scopes.FeatureScope
import com.yasintanriverdi.core.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import com.yasintanriverdi.movies.MoviesPageDataSource
import com.yasintanriverdi.movies.MoviesPageDataSourceFactory
import com.yasintanriverdi.movies.MoviesFragment
import com.yasintanriverdi.movies.MoviesViewModel

@Module
class MoviesModule(
    private val moviesFragment: MoviesFragment
) {

    @Provides
    @FeatureScope
    fun provideViewModel(
        pageDataSourceFactory: MoviesPageDataSourceFactory
    ) = moviesFragment.viewModel {
        MoviesViewModel(pageDataSourceFactory)
    }

    @Provides
    fun provideMovieDataSource(
        moviesRepository: MovieRepository,
        viewModel: MoviesViewModel
    ) = MoviesPageDataSource(moviesRepository, viewModel.viewModelScope)
}