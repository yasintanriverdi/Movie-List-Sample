package com.yasintanriverdi.moviedetail

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.yasintanriverdi.commons.extensions.*
import com.yasintanriverdi.core.data.DataState
import com.yasintanriverdi.core.data.entities.Movie
import com.yasintanriverdi.core.di.provider.CoreComponentProvider
import com.yasintanriverdi.moviedetail.databinding.FragmentMovieDetailBinding
import com.yasintanriverdi.moviedetail.di.DaggerMovieDetailComponent
import com.yasintanriverdi.moviedetail.di.MovieDetailModule
import javax.inject.Inject

class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {

    @Inject
    lateinit var viewModel: MovieDetailViewModel

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setupDependencyInjection()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMovieDetailBinding.bind(view)
        observe(viewModel.state, ::onViewStateChanged)
        observe(viewModel.data, ::onViewDataChanged)
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

    private fun onViewDataChanged(movies: Movie) {
        // TODO - update UI
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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