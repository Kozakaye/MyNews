package com.example.mynews.presentation.navigation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/example/mynews/presentation/navigation/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "DetailScreen", "Favourites", "MainScreen", "Lcom/example/mynews/presentation/navigation/Screen$DetailScreen;", "Lcom/example/mynews/presentation/navigation/Screen$Favourites;", "Lcom/example/mynews/presentation/navigation/Screen$MainScreen;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/mynews/presentation/navigation/Screen$DetailScreen;", "Lcom/example/mynews/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class DetailScreen extends com.example.mynews.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.mynews.presentation.navigation.Screen.DetailScreen INSTANCE = null;
        
        private DetailScreen() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/mynews/presentation/navigation/Screen$Favourites;", "Lcom/example/mynews/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class Favourites extends com.example.mynews.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.mynews.presentation.navigation.Screen.Favourites INSTANCE = null;
        
        private Favourites() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/mynews/presentation/navigation/Screen$MainScreen;", "Lcom/example/mynews/presentation/navigation/Screen;", "()V", "app_debug"})
    public static final class MainScreen extends com.example.mynews.presentation.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.mynews.presentation.navigation.Screen.MainScreen INSTANCE = null;
        
        private MainScreen() {
        }
    }
}