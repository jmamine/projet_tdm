package com.example.rental

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    val endpoint = Retrofit.Builder()
        .baseUrl("https://47e7-41-220-149-145.eu.ngrok.io")
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(Endpoint::class.java)

}