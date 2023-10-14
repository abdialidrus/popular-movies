package com.abdialidrus.popularmovies.domain.use_case

import com.abdialidrus.popularmovies.domain.model.Movie
import com.abdialidrus.popularmovies.domain.repository.MovieRepository
import com.abdialidrus.popularmovies.util.Resource
import kotlinx.coroutines.flow.Flow

class GetFavoriteMovies(private val repository: MovieRepository) {

    operator fun invoke(): Flow<Resource<List<Movie>>> {
        return repository.getFavoriteMovies()
    }
}