package com.abdialidrus.popularmovies.presentation.movie_detail


sealed class MovieDetailEvent {
    data class LoadMovieDetail(val movieId: Int): MovieDetailEvent()
    object LikeDislikeMovie: MovieDetailEvent()
}