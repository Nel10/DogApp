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
import com.dogapp.databinding.FragmentAddCitaBinding
import com.dogapp.model.Cita
import com.dogapp.model.Raza
import com.dogapp.viewmodel.CitaViewModel

class AddCitaFragment : Fragment() {
    private lateinit var binding: FragmentAddCitaBinding
    private val citaViewModel: CitaViewModel by viewModels()
    private var razas: MutableList<Raza> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddCitaBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controladores()
        observadorViewModel()
    }

    private fun controladores() {
        val sintomas = resources.getStringArray(R.array.sintomas_lista).toList()
        val adapterSintomas = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            sintomas
        )
        adapterSintomas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spSintoma.adapter = adapterSintomas
        binding.etRaza.threshold = 2

        binding.btnAtras.setOnClickListener {
            findNavController().popBackStack()
        }
        validarDatos()
        binding.btnGuardarCita.setOnClickListener {
            guardarCita()
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
                val llenos = listaCampos.all { it.text.toString().trim().isNotEmpty() }
                binding.btnGuardarCita.isEnabled = llenos
            }
        }
    }

    private fun guardarCita() {
        if (binding.spSintoma.selectedItemPosition == 0) {
            Toast.makeText(context, getString(R.string.selecciona_sintoma), Toast.LENGTH_SHORT).show()
            return
        }
        val nombreRaza = binding.etRaza.text.toString().trim()
        val raza = razas.find { it.nombre.equals(nombreRaza, ignoreCase = true) }
        if (raza == null) {
            Toast.makeText(context, getString(R.string.selecciona_raza), Toast.LENGTH_SHORT).show()
            return
        }
        val cita = Cita(
            nombreMascota = binding.etNombreMascota.text.toString().trim(),
            raza = raza.nombre,
            nombrePropietario = binding.etNombrePropietario.text.toString().trim(),
            telefono = binding.etTelefono.text.toString().trim(),
            sintoma = binding.spSintoma.selectedItem.toString(),
            imagen = ""
        )
        binding.btnGuardarCita.isEnabled = false
        citaViewModel.guardarCitaNueva(cita, raza.ruta)
    }

    private fun observadorViewModel() {
        observerRazas()
        observerCitaGuardada()
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

    private fun observerCitaGuardada() {
        citaViewModel.citaGuardada.observe(viewLifecycleOwner) { guardada ->
            if (guardada) {
                binding.cvConfirmacion.isVisible = true
                binding.cvConfirmacion.postDelayed({
                    if (isAdded) {
                        findNavController().popBackStack()
                    }
                }, 900)
            }
        }
    }

    private fun observerMensaje() {
        citaViewModel.mensaje.observe(viewLifecycleOwner) { mensaje ->
            if (mensaje.isNotEmpty()) {
                Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
                binding.btnGuardarCita.isEnabled = true
            }
        }
    }

    private fun observerProgress() {
        citaViewModel.progressState.observe(viewLifecycleOwner) { status ->
            binding.progress.isVisible = status
        }
    }
}
