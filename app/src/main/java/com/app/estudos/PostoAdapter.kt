package com.app.estudos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.estudos.R
import com.app.estudos.R.id.textDistanciaPosto
import com.app.estudos.R.id.textEnderecoPosto
import com.app.estudos.model.Posto

class PostoAdapter(private val lista: List<Posto>) :
    RecyclerView.Adapter<PostoAdapter.PostoViewHolder>() {

    class PostoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomePosto: TextView = itemView.findViewById(R.id.textNomePosto)
        val enderecoPosto: TextView = itemView.findViewById(textEnderecoPosto)
        val distanciaPosto: TextView = itemView.findViewById(textDistanciaPosto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_posto, parent, false)
        return PostoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostoViewHolder, position: Int) {
        val posto = lista[position]
        holder.nomePosto.text = posto.nome
        holder.enderecoPosto.text = posto.endereco
        holder.distanciaPosto.text = posto.distancia
    }

    override fun getItemCount(): Int = lista.size
}
