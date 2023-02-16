package com.example.sourcebbcnews.ui

import androidx.lifecycle.ViewModel
import com.example.sourcebbcnews.repository.NewsRepository
import javax.inject.Inject

class ContentViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    init {

    }

}