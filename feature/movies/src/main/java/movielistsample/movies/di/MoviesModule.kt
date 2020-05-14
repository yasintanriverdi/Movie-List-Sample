package movielistsample.movies.di

import com.yasintanriverdi.commons.extensions.viewModel
import com.yasintanriverdi.core.data.AppCoroutineDispatchers
import com.yasintanriverdi.core.di.scopes.FeatureScope
import com.yasintanriverdi.core.usecases.FetchMoviesUseCase
import dagger.Module
import dagger.Provides
import movielistsample.movies.MoviesFragment
import movielistsample.movies.MoviesViewModel

@Module
class MoviesModule(
    private val moviesFragment: MoviesFragment
) {

    @Provides
    @FeatureScope
    fun provideViewModel(
        fetchMoviesUseCase: FetchMoviesUseCase,
        appCoroutineDispatchers: AppCoroutineDispatchers
    ) = moviesFragment.viewModel {
        MoviesViewModel(fetchMoviesUseCase, appCoroutineDispatchers.io)
    }
}