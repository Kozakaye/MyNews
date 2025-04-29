package com.example.mynews.presentation.navigation

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object DetailScreen: Screen("detail_screen")
    object Favourites: Screen("favourites")
}