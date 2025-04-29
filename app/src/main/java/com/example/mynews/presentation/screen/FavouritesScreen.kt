package com.example.mynews.presentation.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mynews.data.local.SavedNews
import com.example.mynews.presentation.viewmodel.NewsViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Favourites(viewModel: NewsViewModel, navController: NavController) {
    val news by viewModel.savedNews.collectAsState()

    LazyColumn {
        stickyHeader {
            TopNavBar(navController)
        }

        items(news) { newsItem ->
            SavedNewsCard(newsItem)
        }
    }
}

@Composable
fun SavedNewsCard(news: SavedNews) {
    //todo UI
    Text(news.title)
}