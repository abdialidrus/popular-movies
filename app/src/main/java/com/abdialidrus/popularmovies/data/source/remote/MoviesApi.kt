package com.abdialidrus.popularmovies.data.source.remote

import com.abdialidrus.popularmovies.data.source.remote.dto.PopularMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int): PopularMoviesResponse

}