package com.maikals.data.service.repository

import com.maikals.domain.entities.MovieEntity
import com.maikals.domain.entities.MovieListEntity

interface MoviesRepository {
    suspend fun getMostPopularMoviesList(page: Int): MovieListEntity
    suspend fun getMostPopularMoviesLocal(): MovieListEntity
    fun setMostPopularMoviesLocal(moviesList: List<MovieEntity>)
}