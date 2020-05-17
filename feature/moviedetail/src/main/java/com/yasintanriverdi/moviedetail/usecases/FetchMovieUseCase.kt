package com.yasintanriverdi.moviedetail.usecases

import com.yasintanriverdi.core.repositories.MovieRepository
import javax.inject.Inject

class FetchMovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    suspend fun getMovieById(movieId: Int) = movieRepository.getMovieById(movieId)

}