package com.abdialidrus.popularmovies.domain.use_case

import com.abdialidrus.popularmovies.domain.model.Movie
import com.abdialidrus.popularmovies.domain.repository.MovieRepository
import com.abdialidrus.popularmovies.util.Resource

class FavoriteMovie(private val repository: MovieRepository) {

    operator fun invoke(movieId: Int): Resource<Movie> {
        return repository.toggleMovieFavorite(movieId, isFavorite = true)
    }
}