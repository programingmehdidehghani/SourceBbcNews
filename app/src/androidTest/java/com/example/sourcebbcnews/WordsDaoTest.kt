package com.example.sourcebbcnews

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.sourcebbcnews.db.NewsDAO
import com.example.sourcebbcnews.db.NewsDB
import com.example.sourcebbcnews.ui.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
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

    @After
    fun closeDatabase() {
        database.close()
    }
}