package com.maikals.domain.service

interface MoviesService {
    fun getUpcomingMovies(id: Int, page: Int)
}