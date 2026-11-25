package com.dogapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val _autenticado = MutableLiveData(false)
    val autenticado: LiveData<Boolean> = _autenticado

    fun loginCorrecto() {
        _autenticado.value = true
    }
}
