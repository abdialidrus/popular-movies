package com.abdialidrus.popularmovies.domain.repository

import com.abdialidrus.popularmovies.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPopularMovies(): Flow<List<Movie>>

    fun getFavoriteMovies(): Flow<List<Movie>>

    fun getMovieById(id: Int): Movie?

    fun setMovieAsFavorite(movie: Movie): Movie?
}