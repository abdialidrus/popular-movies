package com.abdialidrus.popularmovies.data

import com.abdialidrus.popularmovies.data.source.local.MovieDao
import com.abdialidrus.popularmovies.data.source.remote.MoviesApi
import com.abdialidrus.popularmovies.domain.model.Movie
import com.abdialidrus.popularmovies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl(
    private val dao: MovieDao,
    private val api: MoviesApi
): MovieRepository {

    override fun getPopularMovies(): Flow<List<Movie>> {
        TODO("Not yet implemented")
    }

    override fun getFavoriteMovies(): Flow<List<Movie>> {
        TODO("Not yet implemented")
    }

    override fun getMovieById(id: Int): Movie? {
        TODO("Not yet implemented")
    }

    override fun toggleMovieFavorite(movieId: Int, isFavorite: Boolean): Movie {
        TODO("Not yet implemented")
    }

}