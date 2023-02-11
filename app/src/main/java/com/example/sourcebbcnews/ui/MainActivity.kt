package com.example.sourcebbcnews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sourcebbcnews.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    private val newsViewModel : NewsViewModel by viewmodels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}