package com.abdialidrus.popularmovies.presentation

sealed class Screens(val route : String) {
    object MainScreen: Screens("main_screen")
    object Popular : Screens("popular_screen")
    object Favorite : Screens("favorite_screen")
    object DetailScreen: Screens("detail_screen")
}