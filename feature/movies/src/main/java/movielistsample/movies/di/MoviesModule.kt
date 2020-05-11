package movielistsample.movies.di

import com.yasintanriverdi.commons.extensions.viewModel
import com.yasintanriverdi.core.di.scopes.FeatureScope
import com.yasintanriverdi.core.network.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import movielistsample.movies.MoviesFragment
import movielistsample.movies.MoviesViewModel

@Module
class MoviesModule(
    val moviesFragment: MoviesFragment
) {

    @Provides
    @FeatureScope
    fun provideViewModel(
        movieRepository: MovieRepository
    ) = moviesFragment.viewModel {
        MoviesViewModel(movieRepository)
    }
}