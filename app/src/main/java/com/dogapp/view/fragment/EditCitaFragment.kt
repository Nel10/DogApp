package com.dogapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dogapp.R
import com.dogapp.databinding.FragmentEditCitaBinding
import com.dogapp.model.Cita
import com.dogapp.model.Raza
import com.dogapp.viewmodel.CitaViewModel

class EditCitaFragment : Fragment() {
    private lateinit var binding: FragmentEditCitaBinding
    private val citaViewModel: CitaViewModel by viewModels()
    private lateinit var receivedCita: Cita
    private var razas: MutableList<Raza> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditCitaBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataCita()
        controladores()
        observadorViewModel()
    }

    private fun dataCita() {
        val receivedBundle = arguments
        receivedCita = receivedBundle?.getSerializable("cita") as Cita
    }

    private fun controladores() {
        binding.etRaza.threshold = 2
        binding.btnAtras.setOnClickListener {
            findNavController().popBackStack()
        }
        validarDatos()
        binding.etNombreMascota.setText(receivedCita.nombreMascota)
        binding.etRaza.setText(receivedCita.raza)
        binding.etNombrePropietario.setText(receivedCita.nombrePropietario)
        binding.etTelefono.setText(receivedCita.telefono)
        actualizarEstadoBoton()
        binding.btnEditarCita.setOnClickListener {
            editarCita()
        }
    }

    private fun validarDatos() {
        val listaCampos = listOf(
            binding.etNombreMascota,
            binding.etRaza,
            binding.etNombrePropietario,
            binding.etTelefono
        )
        for (campo in listaCampos) {
            campo.addTextChangedListener {
                actualizarEstadoBoton()
            }
        }
    }

    private fun actualizarEstadoBoton() {
        val llenos = listOf(
            binding.etNombreMascota,
            binding.etRaza,
            binding.etNombrePropietario,
            binding.etTelefono
        ).all { it.text.toString().trim().isNotEmpty() }
        binding.btnEditarCita.isEnabled = llenos
    }

    private fun editarCita() {
        val nombreRaza = binding.etRaza.text.toString().trim()
        val raza = razas.find { it.nombre.equals(nombreRaza, ignoreCase = true) }
        if (raza == null) {
            Toast.makeText(context, getString(R.string.selecciona_raza), Toast.LENGTH_SHORT).show()
            return
        }
        val cita = receivedCita.copy(
            nombreMascota = binding.etNombreMascota.text.toString().trim(),
            raza = raza.nombre,
            nombrePropietario = binding.etNombrePropietario.text.toString().trim(),
            telefono = binding.etTelefono.text.toString().trim()
        )
        binding.btnEditarCita.isEnabled = false
        citaViewModel.actualizarCita(cita, raza.ruta)
    }

    private fun observadorViewModel() {
        observerRazas()
        observerCitaActualizada()
        observerMensaje()
        observerProgress()
    }

    private fun observerRazas() {
        citaViewModel.getRazas()
        citaViewModel.listRazas.observe(viewLifecycleOwner) { lista ->
            razas = lista
            val adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_dropdown_item_1line,
                lista.map { it.nombre }
            )
            binding.etRaza.setAdapter(adapter)
            if (lista.isEmpty()) {
                Toast.makeText(context, getString(R.string.error_razas), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun observerCitaActualizada() {
        citaViewModel.citaActualizada.observe(viewLifecycleOwner) { actualizada ->
            if (actualizada) {
                binding.cvConfirmacion.isVisible = true
                binding.cvConfirmacion.postDelayed({
                    if (isAdded) {
                        findNavController().popBackStack(R.id.homeFragment, false)
                    }
                }, 900)
            }
        }
    }

    private fun observerMensaje() {
        citaViewModel.mensaje.observe(viewLifecycleOwner) { mensaje ->
            if (mensaje.isNotEmpty()) {
                Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
                actualizarEstadoBoton()
            }
        }
    }

    private fun observerProgress() {
        citaViewModel.progressState.observe(viewLifecycleOwner) { status ->
            binding.progress.isVisible = status
        }
    }
}
