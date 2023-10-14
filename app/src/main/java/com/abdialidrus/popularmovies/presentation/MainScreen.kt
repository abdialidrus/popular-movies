package com.abdialidrus.popularmovies.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.abdialidrus.popularmovies.domain.model.Movie
import com.abdialidrus.popularmovies.presentation.favorite_movies.FavoriteMoviesScreen
import com.abdialidrus.popularmovies.presentation.popular_movies.PopularMoviesScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    mainNavController: NavController
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                BottomNavigationItem().bottomNavigationItems().forEachIndexed { _, navigationItem ->
                    NavigationBarItem(
                        selected = navigationItem.route == currentDestination?.route,
                        label = {
                            Text(navigationItem.label)
                        },
                        icon = {
                            Icon(
                                navigationItem.icon,
                                contentDescription = navigationItem.label
                            )
                        },
                        onClick = {
                            navController.navigate(navigationItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.Popular.route,
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            composable(Screens.Popular.route) {
                PopularMoviesScreen { movie ->
                    navigateToDetails(navController = mainNavController, movie = movie)
                }
            }
            composable(Screens.Favorite.route) {
                FavoriteMoviesScreen(
                    navController
                ) { movie ->
                    navigateToDetails(navController = mainNavController, movie = movie)
                }
            }
        }
    }
}

private fun navigateToDetails(navController: NavController, movie: Movie) {
    navController.navigate(
        route = Screens.DetailScreen.route + "?movieId=${movie.id}"
    )
}