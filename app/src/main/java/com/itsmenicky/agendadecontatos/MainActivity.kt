package com.itsmenicky.agendadecontatos

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.itsmenicky.agendadecontatos.databinding.ActivityMainBinding
import com.itsmenicky.agendadecontatos.model.Usuario

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    private val contatosAdapter = ContatosAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCadastrar.setOnClickListener{
            val tela_cadastro = Intent(this, CadastroUsuario::class.java)
            startActivityForResult(tela_cadastro, 1)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview_contatos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = contatosAdapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 1 && resultCode == RESULT_OK){
            val contato = data?.getParcelableExtra<Usuario>("contato")
            contato?.let{
                contatosAdapter.addContato(it)
            }
        }
    }
}