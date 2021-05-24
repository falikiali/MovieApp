package com.example.movieapp.detail

import androidx.lifecycle.ViewModel
import com.example.core.domain.model.PopularMovie
import com.example.core.domain.usecase.PopularMovieUseCase

class DetailViewModel(private val popularMovieUseCase: PopularMovieUseCase) : ViewModel() {
    fun setFavoritePopularMovie(popularMovie: PopularMovie, newState: Boolean) = popularMovieUseCase.setFavoritePopularMovie(popularMovie, newState)
}