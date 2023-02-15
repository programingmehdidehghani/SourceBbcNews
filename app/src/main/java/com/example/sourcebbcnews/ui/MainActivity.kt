package com.example.sourcebbcnews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sourcebbcnews.R
import com.example.sourcebbcnews.adapters.MainNewsAdapter
import com.example.sourcebbcnews.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val newsViewModel: NewsViewModel by viewModels()
    lateinit var newsAdapter: MainNewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        newsViewModel.breakingNews.observe(this, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let { newsResponse ->
                        newsAdapter.differ.submitList(newsResponse.articles.toList())
                        Log.i("tag", "data is ..." + newsResponse)
                    }
                }
                is Resource.Error -> {
                    response.message?.let { message ->
                        Toast.makeText(this, "An error occured: $message", Toast.LENGTH_LONG).show()
                    }
                }
                is Resource.Loading -> {

                }
            }
        })

        newsAdapter.setOnItemClickListener {
           Toast.makeText(this,"min",Toast.LENGTH_LONG).show()
        }
    }

    private fun setupRecyclerView(){
        newsAdapter = MainNewsAdapter()
        rv_main_news.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}