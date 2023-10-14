package com.abdialidrus.popularmovies.data

import com.abdialidrus.popularmovies.data.source.local.MovieDao
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

    override fun getPopularMovies(): Flow<Resource<List<Movie>>> {
        return flow {
            emit(Resource.Loading(true))
            try {
                val response = api.getPopularMovies(1)
                response.results.forEach { movieDto ->
                    dao.insertMovie(movieDto.toEntity(isFavoriteMovie(movieDto.id)))
                }

                emit(Resource.Success(data = response.results.map { it.toMovie(isFavoriteMovie(it.id)) }))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
            }
            emit(Resource.Loading(false))
        }
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
                val remoteMovie = api.getMovieDetail(id)
                emit(Resource.Success(data = remoteMovie.toMovie(isFavoriteMovie(remoteMovie.id))))
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