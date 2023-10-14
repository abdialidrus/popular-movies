package com.abdialidrus.popularmovies.presentation.popular_movies

import com.abdialidrus.popularmovies.domain.model.Movie

data class PopularMoviesState (
    val isLoading: Boolean = true,
    val searchQuery: String = "",
    val page: Int = 1,
    val movies: List<Movie> = emptyList(),
    val errorMessage: String? = null
)