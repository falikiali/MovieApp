package com.example.core.data.source.local

import com.example.core.data.source.local.entity.PopularMovieEntity
import com.example.core.data.source.local.room.AppDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val appDao: AppDao) {
    fun getAllPopularMovies(): Flow<List<PopularMovieEntity>> = appDao.getAllPopularMovies()

    fun getFavoriteMovies(): Flow<List<PopularMovieEntity>> = appDao.getFavoriteMovies()

    suspend fun insertMovies(popularMovies: List<PopularMovieEntity>) = appDao.insertMovies(popularMovies)

    fun setFavoriteTourism(popularMovie: PopularMovieEntity, newState: Boolean) {
        popularMovie.isFavorite = newState
        appDao.updateMovie(popularMovie)
    }
}