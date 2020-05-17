package movielistsample.movies.usecases

import com.yasintanriverdi.core.data.Result
import com.yasintanriverdi.core.data.entities.Movie
import movielistsample.movies.repositories.MovieRepository
import javax.inject.Inject

class FetchMoviesUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    suspend fun fetchMovies(page: Int): Result<List<Movie>> {
        return movieRepository.fetchMovies(page)
    }
}