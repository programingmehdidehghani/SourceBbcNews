package com.example.sourcebbcnews

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.sourcebbcnews.db.NewsDAO
import com.example.sourcebbcnews.db.NewsDB
import com.example.sourcebbcnews.models.Article
import com.example.sourcebbcnews.models.Source
import com.example.sourcebbcnews.ui.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject
import javax.inject.Named


@ExperimentalCoroutinesApi
@HiltAndroidTest
@SmallTest
class ArticleDaoTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    private lateinit var wordsDao: NewsDAO

    @Inject
    @Named("test_db")
    private lateinit var database: NewsDB



    @Before
    fun setupDatabase() {
        /*database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NewsDB::class.java
        ).allowMainThreadQueries().build()*/
        hiltRule.inject()
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