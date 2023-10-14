package com.abdialidrus.popularmovies.presentation.popular_movies.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.abdialidrus.popularmovies.domain.model.Movie
import com.abdialidrus.popularmovies.presentation.common.components.MovieItem

@Composable
fun PopularMovieList(
    modifier: Modifier = Modifier,
    movies: List<Movie>,
    onClick: (Movie) -> Unit,
    onLikeClick: () -> Unit
) {
    if (movies.isEmpty()){
        //EmptyScreen()
    }
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(all = 10.dp)
    ) {
        items(
            count = movies.size,
        ) {
            movies[it].let { movie ->
                MovieItem(movie = movie, onItemClick = { onClick(movie) }) {
                    onLikeClick.invoke()
                }
            }
        }
    }

}

@Composable
fun PopularMovieList(
    modifier: Modifier = Modifier,
    movies: LazyPagingItems<Movie>,
    onClick: (Movie) -> Unit,
    onLikeClick: (Movie) -> Unit
) {

    val handlePagingResult = handlePagingResult(movies)

    if (handlePagingResult) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(all = 10.dp)
        ) {
            items(
                count = movies.itemCount,
            ) {
                movies[it]?.let { movie ->
                    MovieItem(movie = movie, onItemClick = { onClick(movie) }) {
                        onLikeClick.invoke(movie)
                    }
                }
            }
        }
    }
}

@Composable
fun handlePagingResult(articles: LazyPagingItems<Movie>): Boolean {
    val loadState = articles.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when {
        loadState.refresh is LoadState.Loading -> {
            //ShimmerEffect()
            false
        }

        error != null -> {
            //EmptyScreen(error = error)
            false
        }

        else -> {
            true
        }
    }
}