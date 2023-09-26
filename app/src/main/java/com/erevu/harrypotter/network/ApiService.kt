package com.erevu.harrypotter.network

import android.telecom.Call
import com.erevu.harryporter.models.CharacterModel
import com.erevu.harryporter.models.Wand
import com.erevu.harrypotter.utils.RetrofitClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("characters")
    suspend fun getCharacters(): List<CharacterModel>
    companion object{
        var apiService:ApiService?=null
        fun getInstance():ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder().baseUrl(
                    "https://hp-api.onrender.com/api/"

                ).addConverterFactory(GsonConverterFactory.create()).build()
                    .create(ApiService::class.java)
            }

            return apiService!!
        }
    }
}