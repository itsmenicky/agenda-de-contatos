package com.itsmenicky.agendadecontatos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.itsmenicky.agendadecontatos.dao.usuarioDAO
import com.itsmenicky.agendadecontatos.model.Usuario


@Database(entities = [Usuario::class], version = 1)
abstract class appDatabase: RoomDatabase() {

    abstract fun usuarioDAO(): usuarioDAO

    companion object{
        private const val DATABASE_NAME = "DB_AGENDA"

        @Volatile
        private var INSTANCE: appDatabase? = null

        fun getInstance(context: Context): appDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    appDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}