package com.maikals.data.net

import com.maikals.data.entity.MovieListDTO
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query


interface MostPopularMoviesService {
    @GET("movie/popular")
    fun getMostPopularMoviesList(@Query("page") page: Int): Deferred<MovieListDTO>
}