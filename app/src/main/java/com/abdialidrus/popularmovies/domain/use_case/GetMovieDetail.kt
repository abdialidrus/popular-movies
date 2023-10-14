package com.abdialidrus.popularmovies.domain.use_case

import com.abdialidrus.popularmovies.domain.model.Movie
import com.abdialidrus.popularmovies.domain.repository.MovieRepository
import com.abdialidrus.popularmovies.util.Resource
import kotlinx.coroutines.flow.Flow

class GetMovieDetail(private val repository: MovieRepository) {

    operator fun invoke(id: Int): Flow<Resource<Movie>> {
        return repository.getMovieDetail(id)
    }
}