package com.abdialidrus.popularmovies.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM MovieEntity")
    fun getMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM MovieEntity WHERE id = :id")
    suspend fun getMovieById(id: Int): MovieEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movieEntity: MovieEntity)

    @Query("Update MovieEntity SET isFavorite = 1 WHERE id = :id")
    suspend fun favoriteMovie(id: Int)

    @Query("Update MovieEntity SET isFavorite = 0 WHERE id = :id")
    suspend fun unFavoriteMovie(id: Int)
}