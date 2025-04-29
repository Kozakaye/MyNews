package com.example.mynews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mynews.presentation.navigation.MyNavigation
import com.example.mynews.presentation.screen.MainScreen
import com.example.mynews.presentation.viewmodel.NewsViewModel
import com.example.mynews.ui.theme.MyNewsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = hiltViewModel<NewsViewModel>()
            MyNewsTheme {
                MyNavigation(viewModel)
            }
        }
    }
}
