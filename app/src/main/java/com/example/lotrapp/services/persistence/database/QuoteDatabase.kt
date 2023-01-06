package com.example.lotrapp.services.persistence.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lotrapp.models.Quote

@Database(
    entities = [Quote::class],
    version = 1
)
abstract class QuoteDatabase : RoomDatabase(){
    abstract fun getQuoteDao() : QuoteDao

    companion object{
        @Volatile
        private var instance : QuoteDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also{ instance = it}
        }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                QuoteDatabase::class.java,
                "quote_db.db"
            ).build()
    }
}