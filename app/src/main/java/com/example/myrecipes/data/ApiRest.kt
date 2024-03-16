package com.example.myrecipes.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit

object ApiRest {
    private const val API_URL = "http://147.182.183.243:8080/"
    private val contentType = MediaType.get("application/json")

    val client = Retrofit.Builder()
        .baseUrl(API_URL) // API base URL
        .addConverterFactory(Json{
            ignoreUnknownKeys = true
        }.asConverterFactory(contentType))
        .build() // Create Retrofit instance
        .create(RecipesApi::class.java)
}