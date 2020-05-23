package com.yasintanriverdi.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yasintanriverdi.movies.databinding.MoviesItemLoadStatusBinding
import com.yasintanriverdi.movies.MoviesViewModel
import com.yasintanriverdi.movies.MoviesViewState

class StatusFooterAdapter(private val moviesViewModel: MoviesViewModel) :
    RecyclerView.Adapter<StatusFooterAdapter.StatusFooterViewHolder>() {

    internal var viewState: MoviesViewState? = null
        set(value) {
            notifyDataSetChanged()
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusFooterViewHolder {
        val binding = MoviesItemLoadStatusBinding.inflate(LayoutInflater.from(parent.context))
        return StatusFooterViewHolder(binding)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: StatusFooterViewHolder, position: Int) {
        holder.bind(viewState, moviesViewModel)
    }

    inner class StatusFooterViewHolder(private val binding: MoviesItemLoadStatusBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(state: MoviesViewState?, moviesViewModel: MoviesViewModel) {
            state?.let {
                with(binding) {
                    viewState = state
                    viewModel = moviesViewModel
                    executePendingBindings()
                }
            }
        }
    }
}