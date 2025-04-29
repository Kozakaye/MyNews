package com.example.mynews.presentation.state

data class NewsState(
    var onSuccess: Boolean = false,
    var isLoading: Boolean = true,
    var onError: Boolean = false
)
