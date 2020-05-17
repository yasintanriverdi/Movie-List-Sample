package com.yasintanriverdi.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yasintanriverdi.core.data.DataState
import com.yasintanriverdi.core.data.entities.Movie
import com.yasintanriverdi.moviedetail.usecases.FetchMovieUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    private val fetchMovieUseCase: FetchMovieUseCase
) : ViewModel() {

    private val _data = MutableLiveData<Movie>()
    val data: LiveData<Movie>
        get() = _data

    private val _state = MutableLiveData<MovieDetailViewState>()
    val state: LiveData<MovieDetailViewState>
        get() = _state

    fun fetchMovie() {
        val movieId = 1
        _state.postValue(MovieDetailViewState(dataState = DataState.Loading))
        viewModelScope.launch {
            val movie = fetchMovieUseCase.getMovieById(movieId)
            if (movie != null) {
                _state.postValue(MovieDetailViewState(dataState = DataState.Success()))
                _data.postValue(movie)
            } else {
                _state.postValue(
                    MovieDetailViewState(
                        dataState = DataState.Error("Error occured during fetching the movie")
                    )
                )
            }
        }
    }

}