package com.abdialidrus.popularmovies.domain.repository

import androidx.paging.PagingData
import com.abdialidrus.popularmovies.domain.model.Movie
import com.abdialidrus.popularmovies.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getPopularMovies(): Flow<PagingData<Movie>>

    fun getFavoriteMovies(): Flow<Resource<List<Movie>>>

    fun getMovieDetail(id: Int): Flow<Resource<Movie>>

    fun toggleMovieFavorite(movie: Movie): Flow<Resource<Movie?>>
}