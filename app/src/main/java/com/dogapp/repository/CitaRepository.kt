package com.dogapp.repository

import android.content.Context
import com.dogapp.data.CitaDB
import com.dogapp.data.CitaDao
import com.dogapp.model.Cita
import com.dogapp.model.Raza
import com.dogapp.webservice.ApiService
import com.dogapp.webservice.ApiUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CitaRepository(val context: Context) {
    private var citaDao: CitaDao = CitaDB.getDatabase(context).citaDao()
    private var apiService: ApiService = ApiUtils.getApiService()

    suspend fun saveCita(cita: Cita) {
        withContext(Dispatchers.IO) {
            citaDao.saveCita(cita)
        }
    }

    suspend fun getListCita(): MutableList<Cita> {
        return withContext(Dispatchers.IO) {
            citaDao.getListCita()
        }
    }

    suspend fun deleteCita(cita: Cita) {
        withContext(Dispatchers.IO) {
            citaDao.deleteCita(cita)
        }
    }

    suspend fun updateCita(cita: Cita) {
        withContext(Dispatchers.IO) {
            citaDao.updateCita(cita)
        }
    }

    suspend fun getRazas(): MutableList<Raza> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getRazas()
                val lista = mutableListOf<Raza>()
                for ((raza, subrazas) in response.message) {
                    lista.add(Raza(nombre = raza, ruta = raza))
                    for (subraza in subrazas.orEmpty()) {
                        lista.add(Raza(nombre = "$subraza $raza", ruta = "$raza/$subraza"))
                    }
                }
                lista.sortBy { it.nombre }
                lista
            } catch (e: Exception) {
                e.printStackTrace()
                mutableListOf()
            }
        }
    }

    suspend fun getImagenRaza(ruta: String): String {
        return withContext(Dispatchers.IO) {
            val response = apiService.getImagenRaza(ruta)
            if (response.status != "success" || response.message.isEmpty()) {
                throw IllegalStateException("sin imagen")
            }
            response.message
        }
    }
}
