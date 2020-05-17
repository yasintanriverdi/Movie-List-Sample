package com.yasintanriverdi.core.datasource.remote

import com.yasintanriverdi.core.data.Result
import com.yasintanriverdi.core.network.responses.PopularMoviesResponse
import com.yasintanriverdi.core.network.responses.PopularMoviesResponseItem
import com.yasintanriverdi.core.network.services.MovieService
import retrofit2.Response
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
    private val movieService: MovieService
) {

    suspend fun fetchMovies(page: Int): Result<List<PopularMoviesResponseItem>> {
        return try {
            val response = movieService.fetchMovies(page)
            getResult(response = response, onError = {
                Result.Error("Error fetching movies ${response.code()} ${response.message()}")
            })
        } catch (e: Exception) {
            Result.Error("Error fetching movies")
        }
    }

    private inline fun getResult(
        response: Response<PopularMoviesResponse>,
        onError: () -> Result.Error
    ): Result<List<PopularMoviesResponseItem>> {
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                return Result.Success(body.results)
            }
        }
        return onError.invoke()
    }
}