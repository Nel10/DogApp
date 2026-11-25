package com.dogapp.model

import com.google.gson.annotations.SerializedName

data class ImagenResponse(
    @SerializedName("message")
    val message: String,

    @SerializedName("status")
    val status: String
)
