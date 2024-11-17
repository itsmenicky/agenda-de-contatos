package com.itsmenicky.agendadecontatos

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.itsmenicky.agendadecontatos.model.Usuario

class ContatosAdapter: RecyclerView.Adapter<ContatosAdapter.ContatoViewHolder>() {

    private val contatos = mutableListOf<Usuario>()

    fun addContato(newContato: Usuario){
        contatos.add(newContato)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contato_layout, parent, false)
        return ContatoViewHolder(view)
    }

    override fun getItemCount(): Int = contatos.size


    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        val contato = contatos[position]
        holder.bind(contato)
    }
    class ContatoViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textNome = view.findViewById<TextView>(R.id.txt_view_contato_nome)
        val textSobrenome = view.findViewById<TextView>(R.id.txt_view_contato_sobrenome)
        fun bind(contato: Usuario){
            textNome.text = contato.nome
            textSobrenome.text = contato.sobrenome
        }
    }
}