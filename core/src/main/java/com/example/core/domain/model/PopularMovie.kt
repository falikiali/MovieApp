package com.example.core.domain.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class PopularMovie(
    val movieId: Int,
    val title: String,
    val poster: String,
    val releaseDate: String,
    val desc: String,
    val isFavorite: Boolean
) : Parcelable
