package com.example.mynews.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("saved-news")
data class SavedNews(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val author: String? = "",
    val title: String = "",
    val description: String? = "",
    val url: String = "",
    val urlToImage: String? = "",
    val publishedAt: String = "",
    val content: String? = ""
)
