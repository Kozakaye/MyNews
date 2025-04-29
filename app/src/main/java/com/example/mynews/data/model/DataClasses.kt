package com.example.mynews.data.model

data class Main(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>,
    val article: Article
)

data class Article(
    val source: Source,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?
)

data class Source(
    val id: String?,
    val name: String
)