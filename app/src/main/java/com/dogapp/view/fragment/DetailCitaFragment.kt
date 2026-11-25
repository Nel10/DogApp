package com.dogapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dogapp.databinding.FragmentDetailCitaBinding
import com.dogapp.model.Cita

class DetailCitaFragment : Fragment() {
    private lateinit var binding: FragmentDetailCitaBinding

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
        val cita = arguments?.getSerializable("cita") as? Cita
        if (cita != null) {
            binding.tvTitulo.text = cita.nombreMascota
        }
    }
}
