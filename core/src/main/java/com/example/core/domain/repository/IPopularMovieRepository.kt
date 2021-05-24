package com.example.core.domain.repository

import com.example.core.data.Resource
import com.example.core.domain.model.PopularMovie
import kotlinx.coroutines.flow.Flow

interface IPopularMovieRepository {
    fun getAllPopularMovies(): Flow<Resource<List<PopularMovie>>>
    fun getFavoritePopularMovies(): Flow<List<PopularMovie>>
    fun setFavoritePopularMovie(popularMovie: PopularMovie, newState: Boolean)
}