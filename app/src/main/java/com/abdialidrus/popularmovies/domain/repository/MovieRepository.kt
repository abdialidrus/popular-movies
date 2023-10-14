package com.abdialidrus.popularmovies.domain.repository

import com.abdialidrus.popularmovies.domain.model.Movie
import com.abdialidrus.popularmovies.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPopularMovies(): Flow<Resource<List<Movie>>>

    fun getFavoriteMovies(): Flow<Resource<List<Movie>>>

    fun getMovieById(id: Int): Resource<Movie>

    fun toggleMovieFavorite(movieId: Int, isFavorite: Boolean): Resource<Movie>
}