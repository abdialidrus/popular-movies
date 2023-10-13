package com.abdialidrus.popularmovies.domain.use_case

import com.abdialidrus.popularmovies.domain.model.Movie
import com.abdialidrus.popularmovies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteMovies(private val repository: MovieRepository) {

    operator fun invoke(): Flow<List<Movie>> {
        return repository.getPopularMovies()
    }
}