package com.example.core.data.source.remote

import com.example.core.data.source.remote.api.ApiService
import com.example.core.data.source.remote.network.ApiResponse
import com.example.core.data.source.remote.response.PopularMovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class RemoteDataSource(private val apiService: ApiService){
    suspend fun getAllPopularMovies(): Flow<ApiResponse<List<PopularMovieResponse>>> {
        return flow { 
            try {
                val response = apiService.getPopularMovies()
                val resultList = response.results
                if (resultList.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (ex: Exception) {
                emit(ApiResponse.Error(ex.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}