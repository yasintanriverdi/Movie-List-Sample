package com.yasintanriverdi.core.datasource.remote

import com.yasintanriverdi.core.data.Result
import com.yasintanriverdi.core.data.entities.Movie
import com.yasintanriverdi.core.mappers.MoviesResponseToMovieMapper
import com.yasintanriverdi.core.network.responses.PopularMoviesResponse
import com.yasintanriverdi.core.network.services.MovieService
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
    private val movieService: MovieService,
    private val movieMapper: MoviesResponseToMovieMapper
) {

    suspend fun fetchMovies(page: Int): Result<List<Movie>> {
        return try {
            val response = movieService.fetchMovies(page)
            getResult(response = response, onError = {
                Result.Error(IOException("Error fetching movies ${response.code()} ${response.message()}"))
            })
        } catch (e: Exception) {
            Result.Error(IOException("Error fetching movies", e))
        }
    }

    private suspend fun getResult(
        response: Response<PopularMoviesResponse>,
        onError: () -> Result.Error
    ): Result<List<Movie>> {
        if (response.isSuccessful) {
            response.body()?.let { body ->
                val result = body.results
                val mappedResults = movieMapper.map(result)
                return Result.Success(mappedResults)
            }
        }
        return onError.invoke()
    }
}