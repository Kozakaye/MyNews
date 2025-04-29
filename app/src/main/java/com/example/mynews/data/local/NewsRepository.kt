package com.example.mynews.data.local

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsDAO: NewsDAO
) {
    suspend fun addNews(news: SavedNews){
        newsDAO.addNews(news)
    }

    fun getAllNews(): Flow<List<SavedNews>> = newsDAO.getAllNews()

    suspend fun deleteNews(news: SavedNews){
        newsDAO.deleteNews(news)
    }

    fun getNewsById(id: Long): Flow<SavedNews> = newsDAO.getNewsById(id)
}