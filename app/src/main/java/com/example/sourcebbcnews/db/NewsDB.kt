package com.example.sourcebbcnews.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.sourcebbcnews.models.Article


@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class NewsDB : RoomDatabase() {

    abstract fun getRunDao() : NewsDAO
}