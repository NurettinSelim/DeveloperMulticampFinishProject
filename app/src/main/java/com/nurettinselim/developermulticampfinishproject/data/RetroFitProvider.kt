package com.nurettinselim.developermulticampfinishproject.data

import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetroFitProvider {

    private val contentType: MediaType = MediaType.get("application/json")

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://5f6642a143662800168e7538.mockapi.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val myApi = retrofit.create<MyApi>()
}