package com.example.sourcebbcnews.repository

import com.example.sourcebbcnews.api.NewsApi
import com.example.sourcebbcnews.db.NewsDB
import com.example.sourcebbcnews.models.Article
import javax.inject.Inject

class NewsRepository @Inject constructor(
   private val newsApi: NewsApi,
   private val db: NewsDB

) {

    suspend fun getBreakingNews(countryCode : String , pageNumber : Int) =
        newsApi.getBreakingNews(countryCode,pageNumber)


    suspend fun upsert (article: MutableList<Article>) = db.getRunDao().insertArticle(article)

    suspend fun getContentNews (publishedAt: String) = db.getRunDao().getContentNews(publishedAt)


}