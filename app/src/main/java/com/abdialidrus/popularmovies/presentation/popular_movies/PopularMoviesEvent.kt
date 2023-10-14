package com.abdialidrus.popularmovies.presentation.popular_movies

import com.abdialidrus.popularmovies.domain.model.Movie

sealed class PopularMoviesEvent {
    data class SearchMovie(val query: String): PopularMoviesEvent()
    data class LikeMovie(val movie: Movie): PopularMoviesEvent()
}