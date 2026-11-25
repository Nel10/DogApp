package com.dogapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.dogapp.databinding.ItemCitaBinding
import com.dogapp.model.Cita
import com.dogapp.view.viewholder.CitaViewHolder

class CitaAdapter(private val listCitas: MutableList<Cita>, private val navController: NavController) :
    RecyclerView.Adapter<CitaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitaViewHolder {
        val binding = ItemCitaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CitaViewHolder(binding, navController)
    }

    override fun getItemCount(): Int {
        return listCitas.size
    }

    override fun onBindViewHolder(holder: CitaViewHolder, position: Int) {
        val cita = listCitas[position]
        holder.setItemCita(cita)
    }
}
