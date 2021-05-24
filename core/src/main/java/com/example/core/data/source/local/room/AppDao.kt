package com.example.core.data.source.local.room

import androidx.room.*
import com.example.core.data.source.local.entity.PopularMovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {
    @Query("SELECT * FROM popular_movie")
    fun getAllPopularMovies(): Flow<List<PopularMovieEntity>>

    @Query("SELECT * FROM popular_movie where is_favorite = 1")
    fun getFavoriteMovies(): Flow<List<PopularMovieEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovies(popularMovies: List<PopularMovieEntity>)

    @Update
    fun updateMovie(popularMovie: PopularMovieEntity)
}