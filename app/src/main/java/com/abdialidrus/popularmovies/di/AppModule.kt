package com.abdialidrus.popularmovies.di

import android.app.Application
import androidx.room.Room
import com.abdialidrus.popularmovies.data.MovieRepositoryImpl
import com.abdialidrus.popularmovies.data.source.local.MovieDatabase
import com.abdialidrus.popularmovies.data.source.remote.MoviesApi
import com.abdialidrus.popularmovies.domain.repository.MovieRepository
import com.abdialidrus.popularmovies.domain.use_case.GetFavoriteMovies
import com.abdialidrus.popularmovies.domain.use_case.GetMovieDetail
import com.abdialidrus.popularmovies.domain.use_case.GetPopularMovies
import com.abdialidrus.popularmovies.domain.use_case.LikeOrDislikeMovie
import com.abdialidrus.popularmovies.domain.use_case.MovieUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieDatabase(app: Application): MovieDatabase {
        return Room.databaseBuilder(
            app,
            MovieDatabase::class.java,
            MovieDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: MoviesApi, db: MovieDatabase): MovieRepository {
        return MovieRepositoryImpl(dao = db.movieDao, api)
    }

    @Provides
    @Singleton
    fun provideMoviesUseCases(repository: MovieRepository): MovieUseCases {
        return MovieUseCases(
            likeOrDislikeMovie = LikeOrDislikeMovie(repository),
            getFavoriteMovies = GetFavoriteMovies(repository),
            getMovieDetail = GetMovieDetail(repository),
            getPopularMovies = GetPopularMovies(repository),
        )
    }
}