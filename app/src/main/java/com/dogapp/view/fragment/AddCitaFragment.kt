package com.dogapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dogapp.databinding.FragmentAddCitaBinding

class AddCitaFragment : Fragment() {
    private lateinit var binding: FragmentAddCitaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddCitaBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }
}
