package com.example.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class PopularMovieResponse(
    @SerializedName("id")
    val movieId: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("poster_path")
    val poster: String,

    @SerializedName("release_date")
    val releaseDate: String,

    @SerializedName("overview")
    val desc: String
)
