package com.abdialidrus.popularmovies.domain.model

data class Movie (
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String,
    val backdropUrl: String,
    val releaseDate: String,
    val voteAverage: Double,
    val voteCount: Int,
    val isFavorite: Boolean,
    val popularity: Double
)