package movielistsample.movies.di

import androidx.lifecycle.viewModelScope
import com.yasintanriverdi.commons.extensions.viewModel
import com.yasintanriverdi.core.data.AppCoroutineDispatchers
import com.yasintanriverdi.core.di.scopes.FeatureScope
import com.yasintanriverdi.core.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import movielistsample.movies.MoviesPageDataSource
import movielistsample.movies.MoviesPageDataSourceFactory
import movielistsample.movies.MoviesFragment
import movielistsample.movies.MoviesViewModel

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
        appCoroutineDispatchers: AppCoroutineDispatchers,
        viewModel: MoviesViewModel
    ) = MoviesPageDataSource(moviesRepository, viewModel.viewModelScope, appCoroutineDispatchers.io)
}