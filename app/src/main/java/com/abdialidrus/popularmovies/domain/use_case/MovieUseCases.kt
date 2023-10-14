package com.abdialidrus.popularmovies.domain.use_case

data class MovieUseCases(
    val favoriteMovie: FavoriteMovie,
    val getFavoriteMovies: GetFavoriteMovies,
    val getMovieDetail: GetMovieDetail,
    val getPopularMovies: GetPopularMovies,
    val unFavoriteMovie: UnFavoriteMovie
)
