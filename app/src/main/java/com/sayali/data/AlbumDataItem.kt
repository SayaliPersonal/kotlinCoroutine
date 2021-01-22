package com.sayali.data


import com.google.gson.annotations.SerializedName

data class AlbumDataItem(
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("id")
    val id: Int, // 100
    @SerializedName("title")
    val title: String // enim repellat iste

)