package com.example.mynews.presentation.screen;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.CardDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.navigation.NavController;
import com.example.mynews.R;
import com.example.mynews.data.local.SavedNews;
import com.example.mynews.data.model.Article;
import com.example.mynews.presentation.navigation.Screen;
import com.example.mynews.presentation.viewmodel.NewsViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u00a8\u0006\t"}, d2 = {"Favourites", "", "viewModel", "Lcom/example/mynews/presentation/viewmodel/NewsViewModel;", "navController", "Landroidx/navigation/NavController;", "SavedNewsCard", "news", "Lcom/example/mynews/data/local/SavedNews;", "app_debug"})
public final class FavouritesScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.ExperimentalFoundationApi.class})
    @androidx.compose.runtime.Composable()
    public static final void Favourites(@org.jetbrains.annotations.NotNull()
    com.example.mynews.presentation.viewmodel.NewsViewModel viewModel, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SavedNewsCard(@org.jetbrains.annotations.NotNull()
    com.example.mynews.data.local.SavedNews news, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    com.example.mynews.presentation.viewmodel.NewsViewModel viewModel) {
    }
}