package com.abdialidrus.popularmovies

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.abdialidrus.popularmovies.domain.model.Movie
import com.abdialidrus.popularmovies.presentation.MainScreen
import com.abdialidrus.popularmovies.presentation.Screens
import com.abdialidrus.popularmovies.presentation.movie_detail.MovieDetailScreen
import com.abdialidrus.popularmovies.ui.theme.PopularMoviesTheme

@Composable
fun PopularMoviesApp() {
    PopularMoviesTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screens.MainScreen.route
            ) {
                composable(route = Screens.MainScreen.route) {
                    MainScreen(mainNavController = navController)
                }
                composable(
                    route = Screens.DetailScreen.route + "?movieId={movieId}",
                    arguments = listOf(
                        navArgument(
                            name = "movieId"
                        ) {
                            type = NavType.IntType
                            defaultValue = -1
                        }
                    )
                ) {
                    MovieDetailScreen()
                }

            }
        }
    }
}