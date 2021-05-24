package com.example.movieapp.di

import com.example.core.domain.usecase.PopularMovieInteractor
import com.example.core.domain.usecase.PopularMovieUseCase
import com.example.movieapp.detail.DetailViewModel
import com.example.movieapp.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<PopularMovieUseCase> { PopularMovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}