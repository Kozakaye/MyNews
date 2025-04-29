package com.example.mynews.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SavedNews::class], version = 1)
abstract class NewsDatabase() : RoomDatabase() {
    abstract fun newsDao(): NewsDAO
}