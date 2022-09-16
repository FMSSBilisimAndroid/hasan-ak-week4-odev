package com.hasan.retrofitapp.model


import com.google.gson.annotations.SerializedName

data class Model(
    @SerializedName("id")
    val id: String?,
    @SerializedName("price")
    val price: Int?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("img_src")
    val img_src: String?
)
