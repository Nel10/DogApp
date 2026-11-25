package com.dogapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dogapp.R
import com.dogapp.databinding.FragmentHomeBinding
import com.dogapp.view.adapter.CitaAdapter
import com.dogapp.viewmodel.CitaViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val citaViewModel: CitaViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controladores()
        observadorViewModel()
    }

    override fun onResume() {
        super.onResume()
        citaViewModel.getListCitas()
    }

    private fun controladores() {
        binding.fbagregar.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addCitaFragment)
        }
    }

    private fun observadorViewModel() {
        observerListCitas()
        observerProgress()
    }

    private fun observerListCitas() {
        citaViewModel.getListCitas()
        citaViewModel.listCitas.observe(viewLifecycleOwner) { lista ->
            val recycler = binding.recyclerview
            val layoutManager = LinearLayoutManager(context)
            recycler.layoutManager = layoutManager
            val adapter = CitaAdapter(lista, findNavController())
            recycler.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }

    private fun observerProgress() {
        citaViewModel.progressState.observe(viewLifecycleOwner) { status ->
            binding.progress.isVisible = status
        }
    }
}
