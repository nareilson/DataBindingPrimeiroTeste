package com.example.myapplication

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface APIClient {
    @GET ("image/random")
    fun getListDod():Call<JsonObject>
}