package com.example.sourcebbcnews.repository

import com.example.sourcebbcnews.api.NewsApi
import javax.inject.Inject

class NewsRepository @Inject constructor(
   private val newsApi: NewsApi
) {

    suspend fun getBreakingNews(countryCode : String , pageNumber : Int) =
        newsApi.getBreakingNews(countryCode,pageNumber)

}