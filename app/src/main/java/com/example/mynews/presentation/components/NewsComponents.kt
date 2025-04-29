package com.example.mynews.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import com.example.mynews.R
import com.example.mynews.data.model.Article
import com.example.mynews.ui.theme.helveticaFont
import com.example.mynews.ui.theme.sfFont

@Composable
fun ImageOfNews(news: Article) {
    Box(
        modifier = Modifier
            .height(220.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
    ) {
        SubcomposeAsyncImage(
            model = news.urlToImage,
            contentDescription = null,
            error = {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painterResource(R.drawable._04),
                        contentDescription = "No image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            loading = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.LightGray.copy(alpha = 0.5f)),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = Color.Black)
                }
            },
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

    }
}

@Composable
fun NewsTitle(news: Article, modifier: Modifier, sizePair: Pair<TextUnit, TextUnit>) {
    Text(
        text = news.title,
        lineHeight = sizePair.first,
        fontSize = sizePair.second,
        fontFamily = sfFont,
        letterSpacing = 0.7.sp,
        modifier = modifier
    )
}

fun textParameter(): Pair<FontFamily, TextUnit> {
    return Pair(helveticaFont, 0.7.sp)
}

@Composable
fun CustomHorizontalDivider() {
    HorizontalDivider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        thickness = 0.8.dp,
        color = Color.Gray
    )
}