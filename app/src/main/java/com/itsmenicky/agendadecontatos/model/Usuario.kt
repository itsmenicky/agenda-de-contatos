package com.itsmenicky.agendadecontatos.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_usuarios")
data class Usuario (
    @ColumnInfo(name = "nome") val nome:String?,
    @ColumnInfo(name = "sobreNome") val sobrenome:String?,
    @ColumnInfo(name = "idade") val idade:Int?,
    @ColumnInfo(name = "telefone") val telefone:Int?
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}