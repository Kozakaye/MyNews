package com.example.mynews.data.remote

import com.example.mynews.data.model.Main
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsService {
    @GET("everything")
    fun getEverythingNews(
        @Query("q")
        query: String,
        @Query("language")
        language: String,
        @Query("apiKey")
        apiKey: String
    ): Call<Main>

    @GET("top-headlines")
    fun getTopHeadlinesNews(
        @Query("country")
        country: String,
        @Query("category")
        category: String?,
        @Query("language")
        language: String,
        @Query("apiKey")
        apiKey: String
    ): Call<Main>

}