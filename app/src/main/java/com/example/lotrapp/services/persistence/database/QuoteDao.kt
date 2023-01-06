package com.example.lotrapp.services.persistence.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.lotrapp.models.Quote

@Dao
interface QuoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(quote: Quote) : Long

    @Query("SELECT * FROM quotes")
    fun getAllQuotes() : LiveData<List<Quote>>

    @Delete
    suspend fun deleteQuote(quote: Quote)



}