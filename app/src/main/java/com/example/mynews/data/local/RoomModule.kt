package com.example.mynews.data.local

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): NewsDatabase {
        return Room.databaseBuilder(
            context, NewsDatabase::class.java,
            "news_db"
        ).build()
    }

    @Provides
    fun provideNewsDao(database: NewsDatabase): NewsDAO {
        return database.newsDao()
    }

}