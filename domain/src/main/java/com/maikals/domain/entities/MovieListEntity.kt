package com.maikals.domain.entities

data class MovieListEntity(
    val page: Int,
    val totalPages: Int,
    val moviesList: List<MovieEntity>
) : BaseEntity()