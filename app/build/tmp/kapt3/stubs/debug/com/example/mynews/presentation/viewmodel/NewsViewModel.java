package com.example.mynews.presentation.viewmodel;

import android.util.Log;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import com.example.mynews.data.local.NewsRepository;
import com.example.mynews.data.local.SavedNews;
import com.example.mynews.data.model.Article;
import com.example.mynews.data.model.Main;
import com.example.mynews.data.remote.NewsService;
import com.example.mynews.presentation.state.NewsState;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.flow.StateFlow;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010,J\u0016\u0010-\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010,J\u0010\u0010.\u001a\u00020*2\u0006\u0010!\u001a\u00020\tH\u0002J\u0014\u0010/\u001a\u00020*2\f\u00100\u001a\b\u0012\u0004\u0012\u00020201J\u0006\u00103\u001a\u00020*J\u0010\u00104\u001a\u00020*2\b\u00105\u001a\u0004\u0018\u00010\tJ\u000e\u00106\u001a\u00020*2\u0006\u00107\u001a\u00020\tJ\u0006\u00108\u001a\u00020*R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\f0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u001eR\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\"\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\f0\"8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010$R\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u00130\"\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010$\u00a8\u00069"}, d2 = {"Lcom/example/mynews/presentation/viewmodel/NewsViewModel;", "Landroidx/lifecycle/ViewModel;", "apiService", "Lcom/example/mynews/data/remote/NewsService;", "repository", "Lcom/example/mynews/data/local/NewsRepository;", "(Lcom/example/mynews/data/remote/NewsService;Lcom/example/mynews/data/local/NewsRepository;)V", "_category", "Landroidx/compose/runtime/MutableState;", "", "_inputValue", "_newsList", "", "Lcom/example/mynews/data/model/Article;", "_query", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_savedNews", "Lcom/example/mynews/data/local/SavedNews;", "_state", "Lcom/example/mynews/presentation/state/NewsState;", "category", "Landroidx/compose/runtime/State;", "getCategory", "()Landroidx/compose/runtime/State;", "categorySafe", "getCategorySafe", "()Ljava/lang/String;", "inputValue", "getInputValue", "setInputValue", "(Landroidx/compose/runtime/State;)V", "newsList", "getNewsList", "query", "Lkotlinx/coroutines/flow/StateFlow;", "getQuery", "()Lkotlinx/coroutines/flow/StateFlow;", "savedNews", "getSavedNews", "state", "getState", "addNews", "", "news", "(Lcom/example/mynews/data/local/SavedNews;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNews", "fetchNews", "handleApiCall", "call", "Lretrofit2/Call;", "Lcom/example/mynews/data/model/Main;", "retry", "updateCategory", "newCategory", "updateInput", "newInput", "updateQuery", "app_debug"})
@kotlin.OptIn(markerClass = {kotlinx.coroutines.FlowPreview.class})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class NewsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.mynews.data.remote.NewsService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.mynews.data.local.NewsRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.lang.String> _inputValue = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.State<java.lang.String> inputValue;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.mynews.data.local.SavedNews>> _savedNews = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.mynews.presentation.state.NewsState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.mynews.presentation.state.NewsState> state = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.util.List<com.example.mynews.data.model.Article>> _newsList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<java.util.List<com.example.mynews.data.model.Article>> newsList = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _query = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> query = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.lang.String> _category = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<java.lang.String> category = null;
    
    @javax.inject.Inject()
    public NewsViewModel(@org.jetbrains.annotations.NotNull()
    com.example.mynews.data.remote.NewsService apiService, @org.jetbrains.annotations.NotNull()
    com.example.mynews.data.local.NewsRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<java.lang.String> getInputValue() {
        return null;
    }
    
    public final void setInputValue(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.State<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.mynews.data.local.SavedNews>> getSavedNews() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.mynews.presentation.state.NewsState> getState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<java.util.List<com.example.mynews.data.model.Article>> getNewsList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<java.lang.String> getCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCategorySafe() {
        return null;
    }
    
    public final void handleApiCall(@org.jetbrains.annotations.NotNull()
    retrofit2.Call<com.example.mynews.data.model.Main> call) {
    }
    
    public final void updateCategory(@org.jetbrains.annotations.Nullable()
    java.lang.String newCategory) {
    }
    
    private final void fetchNews(java.lang.String query) {
    }
    
    public final void updateQuery() {
    }
    
    public final void updateInput(@org.jetbrains.annotations.NotNull()
    java.lang.String newInput) {
    }
    
    public final void retry() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addNews(@org.jetbrains.annotations.NotNull()
    com.example.mynews.data.local.SavedNews news, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteNews(@org.jetbrains.annotations.NotNull()
    com.example.mynews.data.local.SavedNews news, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}