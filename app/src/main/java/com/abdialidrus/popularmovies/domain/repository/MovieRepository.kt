package com.abdialidrus.popularmovies.domain.repository

import com.abdialidrus.popularmovies.domain.model.Movie
import com.abdialidrus.popularmovies.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPopularMovies(): Flow<Resource<List<Movie>>>

    fun getFavoriteMovies(): Flow<Resource<List<Movie>>>

    fun getMovieDetail(id: Int): Flow<Resource<Movie>>

    fun toggleMovieFavorite(movie: Movie, isFavorite: Boolean): Flow<Resource<Movie?>>
}