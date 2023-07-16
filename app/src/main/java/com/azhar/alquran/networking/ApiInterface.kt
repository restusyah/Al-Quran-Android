package com.azhar.alquran.networking

import retrofit2.http.GET
import com.azhar.alquran.model.main.ModelSurah
import com.azhar.alquran.model.main.ModelAyat
import com.azhar.alquran.model.response.ModelResultNearby
import retrofit2.Call
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.ArrayList

/**
Firebase: https://al-quran-8d642.firebaseio.com/data.json?print=pretty
Npoint: https://api.npoint.io/99c279bb173a6e28359c/data
 */

interface ApiInterface {
    @GET("/99c279bb173a6e28359c/data")
    fun getListSurah(): Call<ArrayList<ModelSurah>>

    @GET("/99c279bb173a6e28359c/surat/{nomor}")
    fun getDetailSurah(
        @Path("nomor") nomor: String
    ): Call<ArrayList<ModelAyat>>

    @GET("place/nearbysearch/json")
    fun getDataResult(
        @Query("key") key: String,
        @Query("keyword") keyword: String,
        @Query("location") location: String,
        @Query("rankby") rankby: String
    ): Call<ModelResultNearby>
}