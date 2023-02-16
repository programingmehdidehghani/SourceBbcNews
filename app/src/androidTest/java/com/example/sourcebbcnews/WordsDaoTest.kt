package com.example.sourcebbcnews

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.sourcebbcnews.db.NewsDAO
import com.example.sourcebbcnews.db.NewsDB
import com.example.sourcebbcnews.models.Article
import com.example.sourcebbcnews.models.Source
import com.example.sourcebbcnews.ui.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.CountDownLatch


@RunWith(AndroidJUnit4::class)
class WordsDaoTest {

    private lateinit var database: NewsDB
    private lateinit var wordsDao: NewsDAO

    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setupDatabase() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NewsDB::class.java
        ).allowMainThreadQueries().build()

        wordsDao = database.getRunDao()
    }

    @Test
    fun insertWord_returnsTrue() = runBlocking {
        val source = Source("","peter")
        val name = Article(
            id = 1, "Mary", "",
            "", "", source, "", "", ""
        )
        wordsDao.insertTestArticle(name)
    }


    @After
    fun closeDatabase() {
        database.close()
    }
}