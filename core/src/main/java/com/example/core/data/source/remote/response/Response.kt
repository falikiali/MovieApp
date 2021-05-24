package com.example.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("results")
    val results: List<PopularMovieResponse>
)
