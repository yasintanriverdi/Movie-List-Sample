package movielistsample.movies

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.yasintanriverdi.core.data.entities.Movie
import javax.inject.Inject
import javax.inject.Provider

class MoviesDataSourceFactory @Inject constructor(
    private val movieDataSourceProvider: Provider<MoviesDataSource>
) : DataSource.Factory<Int, Movie>() {

    val sourceLiveData = MutableLiveData<MoviesDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val movieDataSource = movieDataSourceProvider.get()
        sourceLiveData.postValue(movieDataSource)
        return movieDataSource
    }
}