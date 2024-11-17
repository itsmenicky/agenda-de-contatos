package com.itsmenicky.agendadecontatos

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.itsmenicky.agendadecontatos.model.Usuario

class CadastroUsuario : AppCompatActivity() {
    private lateinit var btn_cadastrar : Button
    private lateinit var nome : EditText
    private lateinit var sobrenome : EditText
    private lateinit var telefone : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_usuario)

        btn_cadastrar = findViewById(R.id.adicionar_contato)
        nome = findViewById(R.id.txt_nome)
        sobrenome = findViewById(R.id.txt_sobrenome)
        telefone = findViewById(R.id.txt_telefone)

        val contatosAdapter = ContatosAdapter()

        btn_cadastrar.setOnClickListener{
            val contato = Usuario(
                nome = nome.text.toString(),
                sobrenome = sobrenome.text.toString(),
                telefone = telefone.text.toString().toIntOrNull()
            )

            val resultIntent = Intent()
            resultIntent.putExtra("contato", contato)

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}