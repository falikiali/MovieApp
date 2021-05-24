package com.example.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.PopularMovieUseCase

class FavoriteViewModel(popularMovieUseCase: PopularMovieUseCase) : ViewModel() {
    val favoritePopularMovie = popularMovieUseCase.getFavoritePopularMovies().asLiveData()
}