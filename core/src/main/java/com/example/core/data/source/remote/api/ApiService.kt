package com.example.core.data.source.remote.api

import com.example.core.data.source.remote.response.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
            @Query("api_key") apiKey: String = "4352f20b370f5159e282a10427534613"
    ): Response
}