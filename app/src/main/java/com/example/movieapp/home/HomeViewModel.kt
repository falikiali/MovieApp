package com.example.movieapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.PopularMovieUseCase

class HomeViewModel(popularMovieUseCase: PopularMovieUseCase) : ViewModel() {
    val popularMovie = popularMovieUseCase.getAllPopularMovies().asLiveData()
}