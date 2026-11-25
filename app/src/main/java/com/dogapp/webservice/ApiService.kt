package com.dogapp.webservice

import com.dogapp.model.ImagenResponse
import com.dogapp.model.RazasResponse
import com.dogapp.utils.Constants.END_POINT_RAZAS
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET(END_POINT_RAZAS)
    suspend fun getRazas(): RazasResponse

    @GET("breed/{raza}/images/random")
    suspend fun getImagenRaza(@Path(value = "raza", encoded = true) raza: String): ImagenResponse
}
