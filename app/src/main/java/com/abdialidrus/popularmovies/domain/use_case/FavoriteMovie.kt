package com.abdialidrus.popularmovies.domain.use_case

import com.abdialidrus.popularmovies.domain.model.Movie
import com.abdialidrus.popularmovies.domain.repository.MovieRepository

class SetMovieAsFavorite(private val repository: MovieRepository) {

    operator fun invoke(movie: Movie): Movie? {
        return repository.setMovieAsFavorite(movie)
    }
}