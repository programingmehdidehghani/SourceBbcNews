package com.example.sourcebbcnews.ui

import androidx.lifecycle.ViewModel
import com.example.sourcebbcnews.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    val newsRepository: NewsRepository
) : ViewModel() {
}