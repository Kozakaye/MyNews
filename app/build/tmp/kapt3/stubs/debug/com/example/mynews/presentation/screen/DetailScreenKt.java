package com.example.mynews.presentation.screen;

import android.content.Intent;
import android.net.Uri;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.CardDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavController;
import com.example.mynews.data.model.Article;
import com.example.mynews.presentation.viewmodel.NewsViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a*\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0018\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010\u00a8\u0006\u0013"}, d2 = {"ArticleContent", "", "news", "Lcom/example/mynews/data/model/Article;", "ArticleDescription", "ArticleInfo", "DetailScreen", "modifier", "Landroidx/compose/ui/Modifier;", "viewModel", "Lcom/example/mynews/presentation/viewmodel/NewsViewModel;", "navController", "Landroidx/navigation/NavController;", "SeeArticleButton", "TopNavBar", "titleName", "", "convertDate", "date", "app_debug"})
public final class DetailScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.ExperimentalFoundationApi.class})
    @androidx.compose.runtime.Composable()
    public static final void DetailScreen(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    com.example.mynews.presentation.viewmodel.NewsViewModel viewModel, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    com.example.mynews.data.model.Article news) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TopNavBar(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    java.lang.String titleName) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ArticleInfo(@org.jetbrains.annotations.NotNull()
    com.example.mynews.data.model.Article news) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ArticleDescription(@org.jetbrains.annotations.NotNull()
    com.example.mynews.data.model.Article news) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ArticleContent(@org.jetbrains.annotations.NotNull()
    com.example.mynews.data.model.Article news) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String convertDate(@org.jetbrains.annotations.NotNull()
    java.lang.String date) {
        return null;
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SeeArticleButton(@org.jetbrains.annotations.NotNull()
    com.example.mynews.data.model.Article news) {
    }
}