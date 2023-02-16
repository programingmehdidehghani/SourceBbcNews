package com.example.sourcebbcnews.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sourcebbcnews.models.Article
import com.example.sourcebbcnews.repository.NewsRepository
import javax.inject.Inject

class ContentViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {
    
    fun getContentNews(publishedAt : String) : LiveData<List<Article>> {
        return newsRepository.getContentNews(publishedAt)
    }

}