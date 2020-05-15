package movielistsample.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yasintanriverdi.core.data.entities.Movie
import com.yasintanriverdi.movies.databinding.ItemMovieBinding

class MoviesAdapter() : RecyclerView.Adapter<MoviesAdapter.MovieItemViewHolder>() {

    internal var movies: MutableList<Movie> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context))
        return MovieItemViewHolder(binding)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    inner class MovieItemViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movieItem: Movie) {
            with(binding) {
                movie = movieItem
                executePendingBindings()
            }
        }
    }
}