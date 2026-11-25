package com.dogapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dogapp.model.Cita
import com.dogapp.utils.Constants.NAME_BD

@Database(entities = [Cita::class], version = 1)
abstract class CitaDB : RoomDatabase() {

    abstract fun citaDao(): CitaDao

    companion object {
        fun getDatabase(context: Context): CitaDB {
            return Room.databaseBuilder(
                context.applicationContext,
                CitaDB::class.java,
                NAME_BD
            ).build()
        }
    }
}
