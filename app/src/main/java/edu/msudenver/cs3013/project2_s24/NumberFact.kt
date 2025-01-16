package edu.msudenver.cs3013.project2_s24

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
//this is the data class for the number facts
@JsonClass(generateAdapter = true)
data class NumberFact(
    @Json(name = "text") val fact: String,
    @Json(name = "number") val number: Int,
    @Json(name = "found") val found: Boolean,
    @Json(name = "type") val type: String
)