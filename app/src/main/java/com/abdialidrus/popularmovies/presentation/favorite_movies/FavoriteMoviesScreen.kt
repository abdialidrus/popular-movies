package com.abdialidrus.popularmovies.presentation.favorite_movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.abdialidrus.popularmovies.domain.model.Movie
import com.abdialidrus.popularmovies.presentation.common.components.MovieItem
import com.abdialidrus.popularmovies.presentation.common.observeLifecycle
import com.abdialidrus.popularmovies.presentation.popular_movies.PopularMoviesEvent
import com.abdialidrus.popularmovies.presentation.popular_movies.PopularMoviesViewModel
import kotlinx.coroutines.launch

@Composable
fun FavoriteMoviesScreen(
    navController: NavController,
    viewModel: FavoriteMoviesViewModel = hiltViewModel(),
    navigateToDetail: (Movie) -> Unit,
) {
    val state = viewModel.state.value
    val scope = rememberCoroutineScope()

    viewModel.observeLifecycle(LocalLifecycleOwner.current.lifecycle)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 12.dp, end = 12.dp, top = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Favorite Movies",
                    style = MaterialTheme.typography.headlineMedium
                )

            }

            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(all = 10.dp)
            ) {
                items(state.movies) { movie ->
                    MovieItem(movie = movie, onItemClick = { navigateToDetail(movie) }) {
                        viewModel.onEvent(FavoriteMoviesEvent.LikeDislikeMovie(movie))
                    }
                }
            }
        }
    }
}