package movielistsample.movies.di

import androidx.lifecycle.viewModelScope
import com.yasintanriverdi.commons.extensions.viewModel
import com.yasintanriverdi.core.data.AppCoroutineDispatchers
import com.yasintanriverdi.core.di.scopes.FeatureScope
import dagger.Module
import dagger.Provides
import movielistsample.movies.MoviesDataSource
import movielistsample.movies.MoviesDataSourceFactory
import movielistsample.movies.MoviesFragment
import movielistsample.movies.MoviesViewModel
import movielistsample.movies.usecases.FetchMoviesUseCase

@Module
class MoviesModule(
    private val moviesFragment: MoviesFragment
) {

    @Provides
    @FeatureScope
    fun provideViewModel(
        dataSourceFactory: MoviesDataSourceFactory
    ) = moviesFragment.viewModel {
        MoviesViewModel(dataSourceFactory)
    }

    @Provides
    fun provideMovieDataSource(
        fetchMoviesUseCase: FetchMoviesUseCase,
        appCoroutineDispatchers: AppCoroutineDispatchers,
        viewModel: MoviesViewModel
    ) = MoviesDataSource(fetchMoviesUseCase, viewModel.viewModelScope, appCoroutineDispatchers.io)
}