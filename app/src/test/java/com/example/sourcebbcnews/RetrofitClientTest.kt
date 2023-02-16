package com.example.sourcebbcnews

import com.example.sourcebbcnews.api.NewsApi
import com.example.sourcebbcnews.utils.Constants.Companion.BASE_URL
import org.junit.Test
import retrofit2.Retrofit


class RetrofitClientTest {

    @Test
    fun testRetrofitInstance() {
        //Get an instance of Retrofit
        val adapter = RetRetrofitClientTestNewsApi()
        val instance: Retrofit = RetrofitClient().retrofit
        //Assert that, Retrofit's base url matches to our BASE_URL
        assert(instance.baseUrl().toString() == BASE_URL)
    }
}