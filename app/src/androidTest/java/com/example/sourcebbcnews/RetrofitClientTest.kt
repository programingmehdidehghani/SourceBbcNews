package com.example.sourcebbcnews

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.SmallTest
import com.example.sourcebbcnews.api.NewsApi
import com.example.sourcebbcnews.db.NewsDB
import com.example.sourcebbcnews.ui.MainActivity
import com.example.sourcebbcnews.utils.Constants.Companion.BASE_URL
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject


@ExperimentalCoroutinesApi
@HiltAndroidTest
@SmallTest
class RetrofitClientTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    private lateinit var newsApi : NewsApi


    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testRetrofitInstance() {
        //Get an instance of Retrofit
        hiltRule.inject()
        //Assert that, Retrofit's base url matches to our BASE_URL
    }

}