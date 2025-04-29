package com.example.mynews.presentation.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.mynews.R
import com.example.mynews.data.local.SavedNews
import com.example.mynews.presentation.components.CustomHorizontalDivider
import com.example.mynews.presentation.navigation.Screen
import com.example.mynews.presentation.viewmodel.NewsViewModel
import com.example.mynews.ui.theme.customGray
import com.example.mynews.ui.theme.sfFont
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Favourites(viewModel: NewsViewModel, navController: NavController) {
    val news by viewModel.savedNews.collectAsState()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(customGray)
    ) { paddingValues ->
        LazyColumn(
            Modifier
                .fillMaxSize()
                .background(customGray)
                .padding(paddingValues)
                .padding(horizontal = 18.dp)
        ) {
            stickyHeader {
                TopNavBar(navController, "Favourites")
            }
            item {
                CustomHorizontalDivider()
            }
            items(news) { newsItem ->
                SavedNewsCard(newsItem, navController, viewModel)
            }
        }
    }
}

@Composable
fun SavedNewsCard(news: SavedNews, navController: NavController, viewModel: NewsViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        AsyncImage(
            model = news.urlToImage ?: R.drawable._04,
            contentDescription = news.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                    .height(220.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = news.title,
                lineHeight = 20.sp,
                fontSize = 20.sp,
                fontFamily = sfFont,
                letterSpacing = 0.7.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 5.dp)
                    .weight(1f)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp)
            ) {
                IconButton(
                    onClick = {
                        viewModel.viewModelScope.launch {
                            viewModel.deleteNews(news)
                        }
                    },
                    modifier = Modifier.size(25.dp)
                ) {
                    Icon(imageVector = Icons.Default.Star, contentDescription = null)
                }
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                IconButton(
                    onClick = {
                        navController.navigate(Screen.DetailScreen.route + "/${news.title}")
                    },
                    modifier = Modifier.size(25.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.diagonal_arrow),
                        contentDescription = "Open",
                        modifier = Modifier.size(25.dp)
                    )
                }
            }

        }
    }
}
