package com.example.sourcebbcnews.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sourcebbcnews.models.Article


@Dao
interface NewsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: MutableList<Article>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTestArticle(article: Article)

    @Query("SELECT * FROM articles WHERE publishedAt = :publishedAt")
    fun getContentNews( publishedAt : String) : LiveData<Article>

    @Query("SELECT * FROM articles")
    fun getTestContentNews() : LiveData<List<Article>>
}
