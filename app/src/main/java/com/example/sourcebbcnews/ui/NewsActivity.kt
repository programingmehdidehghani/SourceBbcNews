package com.example.sourcebbcnews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sourcebbcnews.R

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_content)
        var profileName = intent.getStringExtra("publishedAt")


    }
}