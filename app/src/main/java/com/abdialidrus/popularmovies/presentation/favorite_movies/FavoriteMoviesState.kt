package com.abdialidrus.popularmovies.presentation.favorite_movies

import com.abdialidrus.popularmovies.domain.model.Movie

data class FavoriteMoviesState (
    val isLoading: Boolean = true,
    val movies: List<Movie> = emptyList(),
    val errorMessage: String? = null
)