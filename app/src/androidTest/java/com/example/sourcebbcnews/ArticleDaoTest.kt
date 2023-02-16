package com.example.sourcebbcnews

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sourcebbcnews.db.NewsDAO
import com.example.sourcebbcnews.db.NewsDB
import com.example.sourcebbcnews.models.Article
import com.example.sourcebbcnews.models.Source
import com.example.sourcebbcnews.ui.MainActivity
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ArticleDaoTest {

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
            id = 1, "Mary", "the weather is very good",
            "now it's exllent", "2023.01.30", source, "US", "", ""
        )
        wordsDao.insertTestArticle(name)
    }


    @After
    fun closeDatabase() {
        database.close()
    }
}