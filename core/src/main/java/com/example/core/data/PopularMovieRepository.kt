package com.example.core.data

import com.example.core.data.source.local.LocalDataSource
import com.example.core.data.source.remote.RemoteDataSource
import com.example.core.data.source.remote.network.ApiResponse
import com.example.core.data.source.remote.response.PopularMovieResponse
import com.example.core.domain.repository.IPopularMovieRepository
import com.example.core.domain.model.PopularMovie
import com.example.core.utils.DataMapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class PopularMovieRepository(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource) :
    IPopularMovieRepository {
    override fun getAllPopularMovies(): Flow<Resource<List<PopularMovie>>> =
        object : NetwokBoundResource<List<PopularMovie>, List<PopularMovieResponse>>() {
            override fun loadFromDB(): Flow<List<PopularMovie>> =
                localDataSource.getAllPopularMovies().map {
                    DataMapper.mapEntitiesToDomain(it)
                }

            override fun shouldFetch(data: List<PopularMovie>?): Boolean = data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<PopularMovieResponse>>> = remoteDataSource.getAllPopularMovies()

            override suspend fun saveCallResult(data: List<PopularMovieResponse>) {
                val popularMovieList = DataMapper.mapResponseToEntities(data)
                localDataSource.insertMovies(popularMovieList)
            }
        }.asFlow()

    override fun getFavoritePopularMovies(): Flow<List<PopularMovie>> =
        localDataSource.getFavoriteMovies().map {
            DataMapper.mapEntitiesToDomain(it)
        }

    override fun setFavoritePopularMovie(popularMovie: PopularMovie, newState: Boolean) {
        val popularMovieEntity = DataMapper.mapDomainToEntity(popularMovie)
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.setFavoriteTourism(popularMovieEntity, newState)
        }
    }

}