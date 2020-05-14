package movielistsample.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yasintanriverdi.core.data.Result
import com.yasintanriverdi.core.data.UIState
import com.yasintanriverdi.core.data.entities.Movie
import com.yasintanriverdi.core.usecases.FetchMoviesUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
    private val fetchMoviesUseCase: FetchMoviesUseCase,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _data = MutableLiveData<List<Movie>>()
    val data: LiveData<List<Movie>>
        get() = _data

    private val _state = MutableLiveData<MoviesViewState>()
    val state: LiveData<MoviesViewState>
        get() = _state

    init {
        fetchMovies()
    }

    internal fun fetchMovies() {
        _state.postValue(MoviesViewState(uiState = UIState.Loading))
        viewModelScope.launch(dispatcher) {
            when (val moviesResult = fetchMoviesUseCase.fetchMovies(page = 1)) {
                is Result.Success -> {
                    _state.postValue(MoviesViewState(uiState = UIState.Content))
                    _data.postValue(moviesResult.data)
                }
                is Result.Error -> {
                    val errorState = UIState.Error(moviesResult.exception.message!!)
                    _state.postValue(MoviesViewState(uiState = errorState))
                }
            }
        }
    }
}