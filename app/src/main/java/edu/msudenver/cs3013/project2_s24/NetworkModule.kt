package edu.msudenver.cs3013.project2_s24

import NumbersApiService
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NumbersApiService {
    @GET("random/math?json")
    fun getRandomMathFact(): Call<NumberFact>
}

interface NasaApiService {
    @GET("planetary/apod")
    fun getApod(@Query("api_key") apiKey: String, @Query("count") count: Int): Call<List<ApodItem>>
}
// Object declaration creates a singleton - only one instance of NetworkModule will exist
object NetworkModule {
    // Create a Moshi instance for JSON parsing
    private val moshi = Moshi.Builder()
        // Add KotlinJsonAdapterFactory to handle Kotlin-specific features (like nullable types)
        .addLast(KotlinJsonAdapterFactory())
        .build()

    // Create a Retrofit instance for Numbers API
    private val numbersRetrofit = Retrofit.Builder()
        .baseUrl("http://numbersapi.com/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    // Create a Retrofit instance for NASA API
    private val nasaRetrofit = Retrofit.Builder()
        .baseUrl("https://api.nasa.gov/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    // Create an instance of NumbersApiService interface
    val numbersApiService: NumbersApiService = numbersRetrofit.create(NumbersApiService::class.java)

    // Create an instance of NasaApiService interface
    val nasaApiService: NasaApiService = nasaRetrofit.create(NasaApiService::class.java)
}

// Usage example (you would put this in a Fragment or ViewModel):
// val numbersApiService = NetworkModule.numbersApiService
// numbersApiService.getRandomMathFact().enqueue(...)
// val nasaApiService = NetworkModule.nasaApiService
// nasaApiService.getApod("YOUR_API_KEY", 10).enqueue(...)