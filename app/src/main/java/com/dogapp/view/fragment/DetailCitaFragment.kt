package com.dogapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.dogapp.R
import com.dogapp.databinding.FragmentDetailCitaBinding
import com.dogapp.model.Cita
import com.dogapp.viewmodel.CitaViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DetailCitaFragment : Fragment() {
    private lateinit var binding: FragmentDetailCitaBinding
    private val citaViewModel: CitaViewModel by viewModels()
    private lateinit var receivedCita: Cita

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailCitaBinding.inflate(inflater)
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
        binding.tvTitulo.text = receivedCita.nombreMascota
        binding.tvTurno.text = "#${receivedCita.id}"
        binding.tvRaza.text = receivedCita.raza
        binding.tvSintoma.text = receivedCita.sintoma
        binding.tvPropietario.text = getString(R.string.propietario_valor, receivedCita.nombrePropietario)
        binding.tvTelefono.text = getString(R.string.telefono_valor, receivedCita.telefono)
        if (receivedCita.imagen.isNotEmpty()) {
            Glide.with(binding.ivMascota.context)
                .load(receivedCita.imagen)
                .placeholder(R.drawable.img_dog_head)
                .centerCrop()
                .into(binding.ivMascota)
        } else {
            binding.ivMascota.setImageResource(R.drawable.img_dog_head)
        }
    }

    private fun controladores() {
        binding.btnAtras.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.fbeliminar.setOnClickListener {
            confirmarEliminar()
        }
        binding.fbeditar.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("cita", receivedCita)
            findNavController().navigate(R.id.action_detailCitaFragment_to_editCitaFragment, bundle)
        }
    }

    private fun confirmarEliminar() {
        val dialogo = MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.eliminar_cita))
            .setMessage(getString(R.string.confirmar_eliminar))
            .setNegativeButton(getString(R.string.cancelar), null)
            .setPositiveButton(getString(R.string.eliminar)) { _, _ ->
                binding.fbeliminar.isEnabled = false
                citaViewModel.eliminarCita(receivedCita)
            }
            .create()
        dialogo.setOnShowListener {
            dialogo.getButton(AlertDialog.BUTTON_POSITIVE)
                .setTextColor(ContextCompat.getColor(requireContext(), R.color.fab_pink))
        }
        dialogo.show()
    }

    private fun observadorViewModel() {
        observerCitaEliminada()
        observerMensaje()
        observerProgress()
    }

    private fun observerCitaEliminada() {
        citaViewModel.citaEliminada.observe(viewLifecycleOwner) { eliminada ->
            if (eliminada) {
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
                binding.fbeliminar.isEnabled = true
            }
        }
    }

    private fun observerProgress() {
        citaViewModel.progressState.observe(viewLifecycleOwner) { status ->
            binding.progress.isVisible = status
        }
    }
}
