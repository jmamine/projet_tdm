package com.example.rental

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    val endpoint = Retrofit.Builder()
        .baseUrl("https://cd6f-41-220-149-166.eu.ngrok.io")
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(Endpoint::class.java)

}