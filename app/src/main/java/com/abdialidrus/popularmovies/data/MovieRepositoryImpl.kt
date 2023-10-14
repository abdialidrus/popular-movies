package com.abdialidrus.popularmovies.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.abdialidrus.popularmovies.data.source.local.MovieDao
import com.abdialidrus.popularmovies.data.source.remote.MoviePagingSource
import com.abdialidrus.popularmovies.data.source.remote.MoviesApi
import com.abdialidrus.popularmovies.domain.model.Movie
import com.abdialidrus.popularmovies.domain.repository.MovieRepository
import com.abdialidrus.popularmovies.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(
    private val dao: MovieDao,
    private val api: MoviesApi
) : MovieRepository {

    override fun getPopularMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {
                MoviePagingSource(api, dao)
            }
        ).flow
    }

    override fun getFavoriteMovies(): Flow<Resource<List<Movie>>> {
        return flow {
            emit(Resource.Loading(true))
            val favoriteMovies = dao.getFavoriteMovies()
            emit(Resource.Success(data = favoriteMovies.map { it.toMovie() }))
            emit(Resource.Loading(false))
        }
    }

    private suspend fun isFavoriteMovie(movieId: Int): Boolean {
        val cachedMovie = dao.getMovieById(movieId)
        return cachedMovie != null && cachedMovie.isFavorite
    }

    override fun getMovieDetail(id: Int): Flow<Resource<Movie>> {
        return flow {
            emit(Resource.Loading(true))
            try {
                val cachedMovie = dao.getMovieById(id)
                emit(Resource.Success(data = cachedMovie?.toMovie()))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
            }
            emit(Resource.Loading(false))
        }
    }

    override fun toggleMovieFavorite(movie: Movie): Flow<Resource<Movie?>> {
        return flow {
            emit(Resource.Loading(true))
            dao.insertMovie(movie.toEntity(isFavoriteMovie(movie.id).not()))

            val cachedMovie = dao.getMovieById(movie.id)
            emit(Resource.Success(data = cachedMovie?.toMovie()))
            emit(Resource.Loading(false))
        }
    }

}