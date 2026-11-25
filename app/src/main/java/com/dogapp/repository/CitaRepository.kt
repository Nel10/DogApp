package com.dogapp.repository

import android.content.Context
import com.dogapp.data.CitaDB
import com.dogapp.data.CitaDao
import com.dogapp.model.Cita
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CitaRepository(val context: Context) {
    private var citaDao: CitaDao = CitaDB.getDatabase(context).citaDao()

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
}
