package com.sayali.network

import com.sayali.data.AlbumData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface AlbumService {

    @GET("/albums")
    suspend fun getAlbums(): Response<AlbumData>

    //check software update apk
    @GET("/albums")
    fun getUpdateApk(): Call<ResponseBody?>?
}