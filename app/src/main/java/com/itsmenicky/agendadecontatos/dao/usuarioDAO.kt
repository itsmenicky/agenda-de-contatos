package com.itsmenicky.agendadecontatos.dao

import androidx.room.Dao
import androidx.room.Insert
import com.itsmenicky.agendadecontatos.model.Usuario

@Dao
interface usuarioDAO {
    @Insert
    fun inserir(listaUsuario: MutableList<Usuario>)
}