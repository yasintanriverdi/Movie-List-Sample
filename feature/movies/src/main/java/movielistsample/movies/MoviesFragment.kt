package movielistsample.movies

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.yasintanriverdi.commons.extensions.appContext
import com.yasintanriverdi.commons.extensions.observe
import com.yasintanriverdi.core.data.entities.Movie
import com.yasintanriverdi.core.di.provider.CoreComponentProvider
import com.yasintanriverdi.movies.R
import movielistsample.movies.di.DaggerMoviesComponent
import movielistsample.movies.di.MoviesModule
import javax.inject.Inject

class MoviesFragment : Fragment(R.layout.fragment_movies) {

    @Inject
    lateinit var viewModel: MoviesViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerMoviesComponent
            .builder()
            .coreComponent((appContext as CoreComponentProvider).provideCoreComponent())
            .moviesModule(MoviesModule(this))
            .build()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.state, ::onViewStateChanged)
        observe(viewModel.data, ::onContentsChanged)
    }

    private fun onViewStateChanged(viewState: MoviesViewState) {
    }

    private fun onContentsChanged(movies: List<Movie>) {
    }
}