package com.example.mynews.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mynews.presentation.screen.DetailScreen
import com.example.mynews.presentation.screen.Favourites
import com.example.mynews.presentation.screen.MainScreen
import com.example.mynews.presentation.viewmodel.NewsViewModel

@Composable
fun MyNavigation(viewModel: NewsViewModel) {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(Screen.MainScreen.route) {
            MainScreen(viewModel = viewModel, navController = navController)
        }
        composable(
            Screen.DetailScreen.route + "/{title}",
            arguments = listOf(navArgument("title") { type = NavType.StringType })
        ) {
            val title = it.arguments?.getString("title")
            val news = viewModel.newsList.value.find {
                it.title == title
            }
            news?.let {
                DetailScreen(Modifier, viewModel, navController, news)
            }
        }
        composable(Screen.Favourites.route) {
            Favourites(viewModel, navController)
        }
    }
}