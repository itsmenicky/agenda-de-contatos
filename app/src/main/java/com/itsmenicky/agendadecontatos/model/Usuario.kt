package com.itsmenicky.agendadecontatos.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tb_usuarios")
@Parcelize
data class Usuario (
    @ColumnInfo(name = "nome") val nome:String?,
    @ColumnInfo(name = "sobrenome") val sobrenome:String?,
    @ColumnInfo(name = "telefone") val telefone:Int?
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}