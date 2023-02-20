package com.example.sourcebbcnews

import androidx.multidex.BuildConfig
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.SmallTest
import com.example.sourcebbcnews.api.NewsApi
import com.example.sourcebbcnews.db.NewsDB
import com.example.sourcebbcnews.di.RetrofitClient
import com.example.sourcebbcnews.ui.MainActivity
import com.example.sourcebbcnews.utils.Constants
import com.example.sourcebbcnews.utils.Constants.Companion.BASE_URL
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
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

        val instance: Retrofit = RetrofitClient().retrofit

        assert(instance.baseUrl().toUrl().toString() == BASE_URL)
    }

/*    @Test
    fun testPlacesService() {
        val service = PlacesService(RetrofitClient().retrofit)
        val query = VenueRecommendationsQueryBuilder()
            .setLatitudeLongitude(52.376510, 4.905890)
            .build()
        val response = service.getVenueRecommendations(query).execute()
        val errorBody = response.errorBody()
        assert(errorBody == null)
        val responseWrapper = response.body()
        assert(responseWrapper != null)
        assert(response.code() == 200)
    }*/

}