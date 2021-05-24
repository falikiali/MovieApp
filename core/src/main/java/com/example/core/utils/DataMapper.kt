package com.example.core.utils

import com.example.core.data.source.local.entity.PopularMovieEntity
import com.example.core.data.source.remote.response.PopularMovieResponse
import com.example.core.domain.model.PopularMovie

object DataMapper {
    fun mapResponseToEntities(input: List<PopularMovieResponse>): List<PopularMovieEntity> {
        val popularMovieList = ArrayList<PopularMovieEntity>()
        input.map {
            val popularMovie = PopularMovieEntity(
                it.movieId,
                it.title,
                it.poster,
                it.releaseDate,
                it.desc,
                false
            )
            popularMovieList.add(popularMovie)
        }
        return popularMovieList
    }

    fun mapEntitiesToDomain(input: List<PopularMovieEntity>): List<PopularMovie> =
        input.map {
            PopularMovie(
                it.movieId,
                it.title,
                it.poster,
                it.releaseDate,
                it.desc,
                it.isFavorite
            )
        }

    fun mapDomainToEntity(input: PopularMovie) =
        PopularMovieEntity(
            input.movieId,
            input.title,
            input.poster,
            input.releaseDate,
            input.desc,
            input.isFavorite
        )
}