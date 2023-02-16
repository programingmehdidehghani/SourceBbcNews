package com.example.sourcebbcnews.di

import com.example.sourcebbcnews.api.NewsApi
import com.example.sourcebbcnews.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create


@Module
@InstallIn(CustomTestRunner::class)
object TestAppModule {

    @Provides
    fun retrofit() : NewsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }
}