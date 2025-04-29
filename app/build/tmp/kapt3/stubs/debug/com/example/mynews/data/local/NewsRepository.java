package com.example.mynews.data.local;

import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\fJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/mynews/data/local/NewsRepository;", "", "newsDAO", "Lcom/example/mynews/data/local/NewsDAO;", "(Lcom/example/mynews/data/local/NewsDAO;)V", "addNews", "", "news", "Lcom/example/mynews/data/local/SavedNews;", "(Lcom/example/mynews/data/local/SavedNews;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteNews", "getAllNews", "Lkotlinx/coroutines/flow/Flow;", "", "getNewsById", "id", "", "app_debug"})
public final class NewsRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.mynews.data.local.NewsDAO newsDAO = null;
    
    @javax.inject.Inject()
    public NewsRepository(@org.jetbrains.annotations.NotNull()
    com.example.mynews.data.local.NewsDAO newsDAO) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addNews(@org.jetbrains.annotations.NotNull()
    com.example.mynews.data.local.SavedNews news, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.mynews.data.local.SavedNews>> getAllNews() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteNews(@org.jetbrains.annotations.NotNull()
    com.example.mynews.data.local.SavedNews news, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.mynews.data.local.SavedNews> getNewsById(long id) {
        return null;
    }
}