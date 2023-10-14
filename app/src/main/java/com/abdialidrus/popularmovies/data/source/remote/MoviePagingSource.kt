package com.abdialidrus.popularmovies.data.source.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.abdialidrus.popularmovies.data.source.local.MovieDao
import com.abdialidrus.popularmovies.data.source.remote.dto.MovieDto
import com.abdialidrus.popularmovies.data.toEntity
import com.abdialidrus.popularmovies.data.toMovie
import com.abdialidrus.popularmovies.domain.model.Movie

class MoviePagingSource(
    private val api: MoviesApi,
    private val dao: MovieDao
) : PagingSource<Int, Movie>() {
    private var totalNewsCount = 0

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: 1
        return try {
            val newsResponse = api.getPopularMovies(page = page)
            newsResponse.results.forEach {
                dao.insertMovie(it.toEntity(isFavoriteMovie(it.id)))
            }
            totalNewsCount += newsResponse.results.size
            val articles = newsResponse.results.distinctBy { it.id }

            LoadResult.Page(
                data = articles.map { it.toMovie(isFavoriteMovie(it.id)) },
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1,
                prevKey = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }

    private suspend fun isFavoriteMovie(movieId: Int): Boolean {
        val cachedMovie = dao.getMovieById(movieId)
        return cachedMovie != null && cachedMovie.isFavorite
    }
}