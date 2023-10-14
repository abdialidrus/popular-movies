package com.abdialidrus.popularmovies.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class PopularMoviesResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieDto>,
    @SerializedName("total_results")
    val totalResults: Int,
)
