package com.abdialidrus.popularmovies.domain.use_case

import androidx.paging.PagingData
import com.abdialidrus.popularmovies.domain.model.Movie
import com.abdialidrus.popularmovies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetPopularMovies(
    private val repository: MovieRepository
) {

    operator fun invoke(): Flow<PagingData<Movie>> {
        return repository.getPopularMovies()
    }
}