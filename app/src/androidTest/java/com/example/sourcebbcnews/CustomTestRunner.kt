package com.example.sourcebbcnews

import android.app.Application
import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.runner.AndroidJUnitRunner
import com.example.sourcebbcnews.api.NewsApi
import com.example.sourcebbcnews.di.AppModule
import com.example.sourcebbcnews.utils.Constants
import dagger.Module
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import dagger.hilt.testing.TestInstallIn
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import javax.inject.Inject

@HiltAndroidTest
@Module
@TestInstallIn(
    
)
class CustomTestRunner : AndroidJUnitRunner() {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var newsApi : AppModule

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun happyath() {
        val instance: Retrofit = newsApi.RetrofitClient().retrofit
        //Assert that, Retrofit's base url matches to our BASE_URL
        assert(instance.baseUrl().toString() == Constants.BASE_URL)
    }
}