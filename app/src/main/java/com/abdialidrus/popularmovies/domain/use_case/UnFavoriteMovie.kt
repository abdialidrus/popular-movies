package com.abdialidrus.popularmovies.domain.use_case

import com.abdialidrus.popularmovies.domain.model.Movie
import com.abdialidrus.popularmovies.domain.repository.MovieRepository

class UnFavoriteMovie(private val repository: MovieRepository) {

    operator fun invoke(movieId: Int): Movie {
        return repository.toggleMovieFavorite(movieId, isFavorite = false)
    }
}