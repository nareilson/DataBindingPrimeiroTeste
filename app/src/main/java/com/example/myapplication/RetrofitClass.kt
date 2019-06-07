package com.example.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClass {

    fun acessar(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/breeds/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }
}