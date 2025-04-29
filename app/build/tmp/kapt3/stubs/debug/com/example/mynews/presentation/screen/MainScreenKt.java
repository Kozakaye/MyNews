package com.example.mynews.presentation.screen;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavController;
import com.example.mynews.R;
import com.example.mynews.data.local.SavedNews;
import com.example.mynews.data.model.Article;
import com.example.mynews.presentation.navigation.Screen;
import com.example.mynews.presentation.viewmodel.NewsViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u001a\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0018\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\"\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a.\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007\u001aD\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00162\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007\u001a\b\u0010\u001b\u001a\u00020\u0001H\u0007\u00a8\u0006\u001c"}, d2 = {"CardCategory", "", "category", "", "viewModel", "Lcom/example/mynews/presentation/viewmodel/NewsViewModel;", "CustomTextField", "modifier", "Landroidx/compose/ui/Modifier;", "ErrorScreen", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "Header", "navController", "Landroidx/navigation/NavController;", "LazyRowCategories", "LoadingScreen", "MainScreen", "NewsCard", "news", "Lcom/example/mynews/data/model/Article;", "savedNews", "", "Lcom/example/mynews/data/local/SavedNews;", "SuccessScreen", "listState", "Landroidx/compose/foundation/lazy/LazyListState;", "TextBox", "app_debug"})
public final class MainScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void MainScreen(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    com.example.mynews.presentation.viewmodel.NewsViewModel viewModel, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LoadingScreen(@org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.layout.PaddingValues paddingValues) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ErrorScreen(@org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.layout.PaddingValues paddingValues, @org.jetbrains.annotations.NotNull()
    com.example.mynews.presentation.viewmodel.NewsViewModel viewModel) {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.ExperimentalFoundationApi.class})
    @androidx.compose.runtime.Composable()
    public static final void SuccessScreen(@org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.lazy.LazyListState listState, @org.jetbrains.annotations.NotNull()
    androidx.compose.foundation.layout.PaddingValues paddingValues, @org.jetbrains.annotations.NotNull()
    com.example.mynews.presentation.viewmodel.NewsViewModel viewModel, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.mynews.data.model.Article> news, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.mynews.data.local.SavedNews> savedNews) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void Header(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TextBox() {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CustomTextField(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    com.example.mynews.presentation.viewmodel.NewsViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LazyRowCategories(@org.jetbrains.annotations.NotNull()
    com.example.mynews.presentation.viewmodel.NewsViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CardCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    com.example.mynews.presentation.viewmodel.NewsViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void NewsCard(@org.jetbrains.annotations.NotNull()
    com.example.mynews.data.model.Article news, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    com.example.mynews.presentation.viewmodel.NewsViewModel viewModel, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.mynews.data.local.SavedNews> savedNews) {
    }
}