package com.example.core.domain.usecase

import com.example.core.data.Resource
import com.example.core.domain.model.PopularMovie
import com.example.core.domain.repository.IPopularMovieRepository
import kotlinx.coroutines.flow.Flow

class PopularMovieInteractor(private val iPopularMovieRepository: IPopularMovieRepository) :
    PopularMovieUseCase {
    override fun getAllPopularMovies(): Flow<Resource<List<PopularMovie>>> = iPopularMovieRepository.getAllPopularMovies()

    override fun getFavoritePopularMovies(): Flow<List<PopularMovie>> = iPopularMovieRepository.getFavoritePopularMovies()

    override fun setFavoritePopularMovie(popularMovie: PopularMovie, newState: Boolean) = iPopularMovieRepository.setFavoritePopularMovie(popularMovie, newState)
}