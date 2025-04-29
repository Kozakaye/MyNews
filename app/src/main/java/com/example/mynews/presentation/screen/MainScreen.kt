package com.example.mynews.presentation.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.mynews.R
import com.example.mynews.data.local.SavedNews
import com.example.mynews.data.model.Article
import com.example.mynews.presentation.components.CustomHorizontalDivider
import com.example.mynews.presentation.components.ImageOfNews
import com.example.mynews.presentation.components.NewsTitle
import com.example.mynews.presentation.components.textParameter
import com.example.mynews.presentation.navigation.Screen
import com.example.mynews.presentation.viewmodel.NewsViewModel
import com.example.mynews.ui.theme.customGray
import com.example.mynews.ui.theme.sfFont
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: NewsViewModel,
    navController: NavController
) {
    val news: List<Article> = viewModel.newsList.value
    val listState = rememberLazyListState()
    val state by viewModel.state.collectAsState()
    val savedNews by viewModel.savedNews.collectAsState()
    LaunchedEffect(news) {
        if (state.onSuccess && news.isNotEmpty()) {
            listState.animateScrollToItem(0)
        }
    }

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(customGray)
    ) { paddingValues ->
        when {
            state.isLoading -> {
                LoadingScreen(paddingValues)
            }

            state.onError -> {
                ErrorScreen(paddingValues, viewModel)
            }

            state.onSuccess -> {
                SuccessScreen(listState, paddingValues, viewModel, news, navController, savedNews)
            }
        }
    }
}


@Composable
fun LoadingScreen(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(customGray)
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(50.dp),
            color = Color.Black
        )
    }
}

@Composable
fun ErrorScreen(paddingValues: PaddingValues, viewModel: NewsViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Please, check your internet connection",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.error
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                viewModel.retry()
            }) {
                Text("Retry")
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuccessScreen(
    listState: LazyListState,
    paddingValues: PaddingValues,
    viewModel: NewsViewModel,
    news: List<Article>,
    navController: NavController,
    savedNews: List<SavedNews>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(customGray)
            .padding(paddingValues)
            .padding(horizontal = 18.dp),
        state = listState
    ) {
        item {
            Header(navController)
            CustomHorizontalDivider()
            TextBox()
        }

        stickyHeader {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(customGray)
                    .padding(top = 10.dp)
            ) {
                CustomTextField(Modifier, viewModel)
                LazyRowCategories(viewModel)
            }
        }

        items(news) { article ->
            NewsCard(article, navController, viewModel, savedNews)
        }
    }
}


@Composable
fun Header(navController: NavController) {
    val (_, letterSpacing) = textParameter()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(customGray),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.shape_13706738),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )

            Text(
                text = "San",
                fontSize = 18.sp,
                fontFamily = sfFont,
                letterSpacing = letterSpacing,
                modifier = Modifier.padding(start = 2.dp)
            )


        }

        IconButton(
            modifier = Modifier.size(23.dp),
            onClick = {
                navController.navigate(Screen.Favourites.route)
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.favourite),
                contentDescription = null
            )
        }
    }
}


@Composable
fun TextBox() {
    val (_, letterSpacing) = textParameter()
    Box(
        modifier = Modifier
            .size(height = 250.dp, width = 400.dp)
            .padding(top = 10.dp)
    ) {
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = "Some News make people happy.",
            fontSize = 34.7.sp,
            lineHeight = 34.7.sp,
            fontFamily = sfFont,
            letterSpacing = letterSpacing
        )
        Text(
            modifier = Modifier.padding(top = 95.dp, start = 170.dp, end = 15.dp),
            text = "news aggregator service developed by me." +
                    " It presents a continuous flow of links" +
                    " to articles organized from thousands of publishers" +
                    " and magazines.",
            fontFamily = sfFont,
            color = Color.DarkGray,
            letterSpacing = letterSpacing,
            fontSize = 13.sp,
            lineHeight = 13.sp
        )
    }


}

@Composable
fun CustomTextField(modifier: Modifier = Modifier, viewModel: NewsViewModel) {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {
            text = it
            viewModel.updateQuery(text)
        },
        modifier = modifier
            .fillMaxWidth()
            .border(0.5.dp, Color.Gray, RoundedCornerShape(50.dp))
            .clip(RoundedCornerShape(50.dp)),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = customGray,
            focusedContainerColor = customGray,
            unfocusedTextColor = Color.Black,
            focusedTextColor = Color.Black,
            cursorColor = Color.Black,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text(
                text = "Trending, Sports etc",
                fontSize = 13.sp,
                lineHeight = 13.sp
            )
        },
        leadingIcon = {
            Icon(painter = painterResource(R.drawable.search1), contentDescription = null)
        }
    )
}

@Composable
fun LazyRowCategories(viewModel: NewsViewModel) {
    Spacer(modifier = Modifier.padding(top = 20.dp))
    val categories = listOf(
        "All",
        "business", "entertainment",
        "health", "science",
        "sports", "technology"
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        items(categories) { category ->
            CardCategory(category, viewModel)
        }
    }

    Spacer(modifier = Modifier.padding(bottom = 10.dp))

    CustomHorizontalDivider()
}

@Composable
fun CardCategory(category: String, viewModel: NewsViewModel) {
    val (_, letterSpacing) = textParameter()
    val currentCategory = viewModel.category.value
    val isSelected = currentCategory == category

    Card(
        shape = RoundedCornerShape(50),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .height(30.dp)
            .border(0.5.dp, Color.Gray, RoundedCornerShape(50.dp))
            .clip(RoundedCornerShape(50.dp))
            .clickable {
                if (isSelected) {
                    viewModel.updateCategory(null)
                } else {
                    viewModel.updateCategory(category)
                }
            },
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color.White else customGray,
            contentColor = Color.Black,
            disabledContentColor = Color.Black,
            disabledContainerColor = if (isSelected) Color.White else customGray
        )
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = category,
                letterSpacing = letterSpacing,
                fontSize = 13.sp,
                lineHeight = 13.sp
            )
        }
    }
    Spacer(modifier = Modifier.padding(bottom = 20.dp))
}

@Composable
fun NewsCard(
    news: Article, navController: NavController,
    viewModel: NewsViewModel,
    savedNews: List<SavedNews>
) {
    val existingSavedNews = savedNews.find { it.url == news.url }
    val isSelected = existingSavedNews != null

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        ImageOfNews(news)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            NewsTitle(
                news, modifier = Modifier.weight(1f),
                sizePair = 20.sp to 20.sp
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = {
                        viewModel.viewModelScope.launch {
                            if (isSelected) {
                                viewModel.deleteNews(existingSavedNews)
                            } else {
                                val saved = SavedNews(
                                    title = news.title,
                                    author = news.author,
                                    description = news.description,
                                    url = news.url,
                                    urlToImage = news.urlToImage,
                                    content = news.content
                                )
                                viewModel.addNews(saved)
                            }
                        }
                    },
                    modifier = Modifier.size(25.dp)
                ) {
                    if (isSelected) {
                        Icon(imageVector = Icons.Default.Star, contentDescription = null)
                    } else {
                        Icon(painter = painterResource(R.drawable.empty_star_), contentDescription = null,
                            modifier = Modifier.size(20.dp))
                    }
                }

                IconButton(
                    onClick = {
                        navController.navigate(Screen.DetailScreen.route + "/${news.title}")
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.diagonal_arrow),
                        contentDescription = "More details",
                        modifier = Modifier.size(25.dp)
                    )
                }
            }

        }
        Spacer(modifier = Modifier.height(30.dp))
    }
}

