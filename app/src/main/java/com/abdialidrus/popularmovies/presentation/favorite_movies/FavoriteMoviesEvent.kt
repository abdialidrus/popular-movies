package com.abdialidrus.popularmovies.presentation.favorite_movies

import com.abdialidrus.popularmovies.domain.model.Movie

sealed class FavoriteMoviesEvent {
    object LoadFavoriteMovies: FavoriteMoviesEvent()
    data class LikeDislikeMovie(val movie: Movie): FavoriteMoviesEvent()
}