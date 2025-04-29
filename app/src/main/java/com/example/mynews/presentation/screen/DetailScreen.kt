package com.example.mynews.presentation.screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mynews.data.model.Article
import com.example.mynews.presentation.components.CustomHorizontalDivider
import com.example.mynews.presentation.components.ImageOfNews
import com.example.mynews.presentation.components.NewsTitle
import com.example.mynews.presentation.viewmodel.NewsViewModel
import com.example.mynews.ui.theme.customGray
import com.example.mynews.ui.theme.sfFont

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    viewModel: NewsViewModel,
    navController: NavController,
    news: Article
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(customGray)
    ) { paddingValues ->
        LazyColumn(
            modifier
                .fillMaxSize()
                .background(customGray)
                .padding(paddingValues)
                .padding(horizontal = 18.dp)
        ) {
            stickyHeader {
                TopNavBar(navController, "San")

            }
            item {
                CustomHorizontalDivider()
                Spacer(modifier = Modifier.padding(5.dp))
                ImageOfNews(news)
                NewsTitle(news, modifier.padding(top = 10.dp), 24.sp to 24.sp)
                Spacer(modifier = Modifier.padding(top = 20.dp))
                CustomHorizontalDivider()
                ArticleInfo(news)
                CustomHorizontalDivider()
                ArticleDescription(news)
                ArticleContent(news)
                SeeArticleButton(news)
            }
        }
    }
}

@Composable
fun TopNavBar(navController: NavController, titleName: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(customGray)
    ) {
        IconButton(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .size(30.dp),
            onClick = {
                navController.navigateUp()
            }
        ) {
            Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "Go back")
        }

        Text(
            text = titleName,
            fontSize = 18.sp,
            fontFamily = sfFont,
            letterSpacing = 0.7.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun ArticleInfo(news: Article) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 115.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Author:",
                color = Color.DarkGray,
                fontFamily = sfFont,
                letterSpacing = 0.7.sp,
                fontSize = 14.sp,
                lineHeight = 14.sp
            )

            Text(
                text = "Date:",
                color = Color.DarkGray,
                letterSpacing = 0.7.sp,
                fontFamily = sfFont,
                fontSize = 14.sp,
                lineHeight = 14.sp,
                modifier = Modifier.padding(end = 40.dp)
            )
        }

        Spacer(modifier = Modifier.height(2.5.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = news.author ?: "Unknown",
                color = Color.Black,
                letterSpacing = 0.7.sp,
                fontFamily = sfFont,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 5.dp)
            )

            Text(
                text = convertDate(news.publishedAt),
                letterSpacing = 0.7.sp,
                fontFamily = sfFont,
                color = Color.Black,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                modifier = Modifier.padding(end = 40.dp)
            )
        }
    }
}

@Composable
fun ArticleDescription(news: Article) {
    Row() {
        Row(
            modifier = Modifier
                .padding(top = 40.dp)
                .size(30.dp)
                .background(
                    color = Color.Black,
                    shape = RoundedCornerShape(100)
                )
        ) {
            Text("circle")
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(start = 170.dp, top = 35.dp),
        ) {
            Text(
                text = "\"${news.description}\"",
                color = Color.Black,
                letterSpacing = 0.7.sp,
                fontSize = 20.sp,
                lineHeight = 20.sp
            )
            Spacer(modifier = Modifier.padding(top = 35.dp))
            CustomHorizontalDivider()
        }
    }

}

@Composable
fun ArticleContent(news: Article) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp)
    ) {
        Text(
            text = news.content ?: "",
            letterSpacing = 1.sp,
            fontFamily = sfFont,
            color = Color.Black,
            fontSize = 18.sp,
            lineHeight = 18.sp
        )
    }
}

fun convertDate(date: String): String {
    val pureDate = date.substringBefore("T").toString()
    val (year, month, day) = pureDate.split("-")
    val convertedMonth = when (month.toInt()) {
        1 -> "January"
        2 -> "February"
        3 -> "March"
        4 -> "April"
        5 -> "May"
        6 -> "June"
        7 -> "July"
        8 -> "August"
        9 -> "September"
        10 -> "October"
        11 -> "November"
        12 -> "December"
        else -> ""
    }
    val convertedDay = when {
        day.endsWith("1") -> day + "st"
        day.endsWith("2") -> day + "nd"
        day.endsWith("3") -> day + "rd"
        day == "11" -> day + "th"
        day == "12" -> day + "th"
        else -> day + "th"
    }
    return "$convertedDay $convertedMonth, $year"
}

@Composable
fun SeeArticleButton(news: Article) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(news.url))
                context.startActivity(intent)
            },
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            modifier = Modifier
                .height(50.dp)
                .padding(horizontal = 30.dp)
        ) {
            Text(
                text = "Read full article",
                color = Color.White,
                fontSize = 15.sp,
                letterSpacing = 0.7.sp,
                fontFamily = sfFont
            )
        }
    }
}
