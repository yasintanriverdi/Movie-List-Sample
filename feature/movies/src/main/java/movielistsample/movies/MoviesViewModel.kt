package movielistsample.movies

import androidx.lifecycle.ViewModel
import com.yasintanriverdi.core.network.repositories.MovieRepository
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
    val movieRepository: MovieRepository
) : ViewModel() {

    // TODO - will be implemented
}