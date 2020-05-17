package movielistsample.movies.repositories

import com.yasintanriverdi.core.data.Result
import com.yasintanriverdi.core.data.entities.Movie
import com.yasintanriverdi.core.datasource.remote.MovieRemoteDataSource
import com.yasintanriverdi.core.mappers.MoviesResponseToMovieMapper
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource,
    private val movieMapper: MoviesResponseToMovieMapper
) {

    suspend fun fetchMovies(page: Int): Result<List<Movie>> {
        return when (val response = remoteDataSource.fetchMovies(page)) {
            is Result.Success -> {
                val movies = movieMapper.map(response.data)
                Result.Success(movies)
            }
            is Result.Error -> response
        }
    }
}