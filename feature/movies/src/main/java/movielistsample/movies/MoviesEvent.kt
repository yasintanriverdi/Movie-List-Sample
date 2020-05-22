package movielistsample.movies

sealed class MoviesEvent {
    data class OpenMovieDetail(val movieId: Int, val movieTitle: String) : MoviesEvent()
}