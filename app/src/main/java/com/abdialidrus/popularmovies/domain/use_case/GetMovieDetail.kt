package com.abdialidrus.popularmovies.domain.use_case

import com.abdialidrus.popularmovies.domain.model.Movie
import com.abdialidrus.popularmovies.domain.repository.MovieRepository

class GetMovieDetail(private val repository: MovieRepository) {

    operator fun invoke(id: Int): Movie? {
        return repository.getMovieById(id)
    }
}