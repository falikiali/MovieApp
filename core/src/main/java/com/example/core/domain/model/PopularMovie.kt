package com.example.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PopularMovie(
    val movieId: Int,
    val title: String,
    val poster: String,
    val releaseDate: String,
    val desc: String,
    val isFavorite: Boolean
) : Parcelable
