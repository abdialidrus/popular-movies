package com.abdialidrus.popularmovies.domain.use_case

data class MovieUseCases(
    val likeOrDislikeMovie: LikeOrDislikeMovie,
    val getFavoriteMovies: GetFavoriteMovies,
    val getMovieDetail: GetMovieDetail,
    val getPopularMovies: GetPopularMovies,
)
