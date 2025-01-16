package edu.msudenver.cs3013.project2_s24

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
//this is the data class for the apod images
@JsonClass(generateAdapter = true)
data class ApodItem(
    @Json(name = "date") val date: String,
    @Json(name = "explanation") val explanation: String,
    @Json(name = "title") val title: String,
    @Json(name = "url") val url: String,
    @Json(name = "media_type") val mediaType: String,
    @Json(name = "hdurl") val hdUrl: String?
)