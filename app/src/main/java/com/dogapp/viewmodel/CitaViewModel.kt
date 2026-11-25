package com.dogapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dogapp.R
import com.dogapp.model.Cita
import com.dogapp.model.Raza
import com.dogapp.repository.CitaRepository
import kotlinx.coroutines.launch

class CitaViewModel(application: Application) : AndroidViewModel(application) {
    val context = getApplication<Application>()
    private val citaRepository = CitaRepository(context)

    private val _listCitas = MutableLiveData<MutableList<Cita>>()
    val listCitas: LiveData<MutableList<Cita>> get() = _listCitas

    private val _progressState = MutableLiveData(false)
    val progressState: LiveData<Boolean> = _progressState

    private val _listRazas = MutableLiveData<MutableList<Raza>>()
    val listRazas: LiveData<MutableList<Raza>> get() = _listRazas

    private val _citaGuardada = MutableLiveData<Boolean>()
    val citaGuardada: LiveData<Boolean> get() = _citaGuardada

    private val _mensaje = MutableLiveData<String>()
    val mensaje: LiveData<String> get() = _mensaje

    fun saveCita(cita: Cita) {
        viewModelScope.launch {
            _progressState.value = true
            try {
                citaRepository.saveCita(cita)
                _progressState.value = false
            } catch (e: Exception) {
                _progressState.value = false
            }
        }
    }

    fun getListCitas() {
        viewModelScope.launch {
            _progressState.value = true
            try {
                _listCitas.value = citaRepository.getListCita()
                _progressState.value = false
            } catch (e: Exception) {
                _progressState.value = false
            }
        }
    }

    fun deleteCita(cita: Cita) {
        viewModelScope.launch {
            _progressState.value = true
            try {
                citaRepository.deleteCita(cita)
                _progressState.value = false
            } catch (e: Exception) {
                _progressState.value = false
            }
        }
    }

    fun updateCita(cita: Cita) {
        viewModelScope.launch {
            _progressState.value = true
            try {
                citaRepository.updateCita(cita)
                _progressState.value = false
            } catch (e: Exception) {
                _progressState.value = false
            }
        }
    }

    fun getRazas() {
        viewModelScope.launch {
            _progressState.value = true
            try {
                _listRazas.value = citaRepository.getRazas()
                _progressState.value = false
            } catch (e: Exception) {
                _progressState.value = false
            }
        }
    }

    fun guardarCitaNueva(cita: Cita, rutaRaza: String) {
        viewModelScope.launch {
            _progressState.value = true
            try {
                val imagen = citaRepository.getImagenRaza(rutaRaza)
                citaRepository.saveCita(cita.copy(imagen = imagen))
                _progressState.value = false
                _citaGuardada.value = true
            } catch (e: Exception) {
                _progressState.value = false
                _mensaje.value = ""
                _mensaje.value = context.getString(R.string.error_guardar)
            }
        }
    }
}
