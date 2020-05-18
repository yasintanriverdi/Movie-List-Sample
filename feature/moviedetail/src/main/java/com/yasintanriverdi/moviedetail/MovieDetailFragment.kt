package com.yasintanriverdi.moviedetail

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.yasintanriverdi.commons.extensions.observe
import com.yasintanriverdi.commons.extensions.hide
import com.yasintanriverdi.commons.extensions.show
import com.yasintanriverdi.commons.extensions.showSnackbar
import com.yasintanriverdi.commons.extensions.appContext
import com.yasintanriverdi.commons.extensions.loadImage
import com.yasintanriverdi.core.data.DataState
import com.yasintanriverdi.core.data.entities.Movie
import com.yasintanriverdi.core.di.provider.CoreComponentProvider
import com.yasintanriverdi.moviedetail.databinding.MoviedetailFragmentDetailBinding
import com.yasintanriverdi.moviedetail.di.DaggerMovieDetailComponent
import com.yasintanriverdi.moviedetail.di.MovieDetailModule
import javax.inject.Inject

class MovieDetailFragment : Fragment(R.layout.moviedetail_fragment_detail) {

    @Inject
    lateinit var viewModel: MovieDetailViewModel

    private lateinit var binding: MoviedetailFragmentDetailBinding

    private val args: MovieDetailFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setupDependencyInjection()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MoviedetailFragmentDetailBinding.bind(view)

        setupListeners()

        observe(viewModel.state, ::onViewStateChanged)
        observe(viewModel.data, ::onViewDataChanged)

        viewModel.fetchMovie(args.movieId)
    }

    private fun setupListeners() {
        binding.home.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun onViewStateChanged(viewState: MovieDetailViewState) {
        when (val dataState = viewState.dataState) {
            is DataState.Success -> {
                binding.progress.hide()
            }
            is DataState.Error -> {
                binding.progress.hide()
                showSnackbar(dataState.message)
            }
            DataState.Loading -> binding.progress.show()
        }
    }

    private fun onViewDataChanged(movie: Movie) {
        binding.title.text = movie.title
        binding.overview.text = movie.overview
        binding.poster.loadImage(movie.posterUrl)
    }

    private fun setupDependencyInjection() {
        DaggerMovieDetailComponent
            .builder()
            .coreComponent((appContext as CoreComponentProvider).provideCoreComponent())
            .movieDetailModule(MovieDetailModule(this))
            .build()
            .inject(this)
    }
}