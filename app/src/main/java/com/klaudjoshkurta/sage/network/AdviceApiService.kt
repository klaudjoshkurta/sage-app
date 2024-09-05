package com.klaudjoshkurta.sage.network

import com.klaudjoshkurta.sage.model.Advice
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.adviceslip.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface AdviceApiService {
    @GET("advice")
    suspend fun getRandomAdvice(): Advice
}

object AdviceApi {
    val retrofitService: AdviceApiService by lazy {
        retrofit.create(AdviceApiService::class.java)
    }
}