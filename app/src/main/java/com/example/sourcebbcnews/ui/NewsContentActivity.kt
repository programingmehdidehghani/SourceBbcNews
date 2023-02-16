package com.example.sourcebbcnews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.sourcebbcnews.R
import com.example.sourcebbcnews.ui.viewModels.ContentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_news_content.*
import kotlinx.android.synthetic.main.items_headline.view.*

@AndroidEntryPoint
class NewsContentActivity : AppCompatActivity() {

    private val contentViewModel: ContentViewModel by viewModels()
    var publishedAt : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_content)
        publishedAt = intent.getStringExtra("publishedAt").toString()

        contentViewModel.getContentNews(publishedAt).observe(this, Observer {
            tv_title_in_news_content_activity.text = it.title
            tv_descriptions_in_news_content_activity.text = it.description
            tv_content_in_news_content_activity.text = it.content
            Glide.with(this).load(it.urlToImage).into(iv_picture_in_news_content_activity)

        })

    }
}