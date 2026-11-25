package com.dogapp.view.viewholder

import android.os.Bundle
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dogapp.R
import com.dogapp.databinding.ItemCitaBinding
import com.dogapp.model.Cita

class CitaViewHolder(binding: ItemCitaBinding, navController: NavController) :
    RecyclerView.ViewHolder(binding.root) {
    val bindingItem = binding
    val navController = navController

    fun setItemCita(cita: Cita) {
        bindingItem.tvNombre.text = cita.nombreMascota
        bindingItem.tvSintoma.text = cita.sintoma
        bindingItem.tvTurno.text = "# ${cita.id}"

        if (cita.imagen.isNotEmpty()) {
            Glide.with(bindingItem.ivMascota.context)
                .load(cita.imagen)
                .placeholder(R.drawable.img_dog_head)
                .circleCrop()
                .into(bindingItem.ivMascota)
        } else {
            bindingItem.ivMascota.setImageResource(R.drawable.img_dog_head)
        }

        bindingItem.cvCita.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("cita", cita)
            navController.navigate(R.id.action_homeFragment_to_detailCitaFragment, bundle)
        }
    }
}
