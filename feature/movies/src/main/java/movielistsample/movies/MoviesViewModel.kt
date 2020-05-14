package movielistsample.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yasintanriverdi.core.data.Result
import com.yasintanriverdi.core.usecases.FetchMoviesUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
    private val fetchMoviesUseCase: FetchMoviesUseCase,
    dispatcher: CoroutineDispatcher
) : ViewModel() {

    init {
        viewModelScope.launch(dispatcher) {
            when (val moviesResult = fetchMoviesUseCase.fetchMovies(page = 1)) {
                is Result.Success -> {
                    val response = moviesResult.data
                }
                is Result.Error -> {
                }
            }
        }
    }
}