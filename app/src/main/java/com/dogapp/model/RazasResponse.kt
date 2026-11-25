package com.dogapp.model

import com.google.gson.annotations.SerializedName

data class RazasResponse(
    @SerializedName("message")
    val message: Map<String, List<String>?>,

    @SerializedName("status")
    val status: String
)
