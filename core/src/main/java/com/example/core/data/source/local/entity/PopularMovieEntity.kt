package com.example.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popular_movie")
data class PopularMovieEntity (
    @PrimaryKey
    @ColumnInfo(name = "movie_id")
    var movieId: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "poster")
    var poster: String,

    @ColumnInfo(name = "release_date")
    var releaseDate: String,

    @ColumnInfo(name = "desc")
    var desc: String,

    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean
)