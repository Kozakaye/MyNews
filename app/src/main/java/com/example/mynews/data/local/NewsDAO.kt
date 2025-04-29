package com.example.mynews.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDAO {
    @Insert
    suspend fun addNews(savedNews: SavedNews)

    @Query("Select * from `saved-news`")
    fun getAllNews(): Flow<List<SavedNews>>

    @Delete
    suspend fun deleteNews(savedNews: SavedNews)

    @Query("Select * from `saved-news` where id=:id")
    fun getNewsById(id: Long): Flow<SavedNews>
}