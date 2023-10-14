package com.abdialidrus.popularmovies.data

import com.abdialidrus.popularmovies.data.source.local.MovieEntity
import com.abdialidrus.popularmovies.data.source.remote.dto.MovieDto
import com.abdialidrus.popularmovies.domain.model.Movie

fun MovieEntity.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterUrl = posterUrl,
        backdropUrl = backdropUrl,
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        voteCount = voteCount,
        isFavorite = true,
        popularity = popularity
    )
}

fun MovieDto.toMovie(isFavorite: Boolean): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterUrl = posterPath,
        backdropUrl = backdropPath,
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        voteCount = voteCount,
        isFavorite = isFavorite,
        popularity = popularity
    )
}