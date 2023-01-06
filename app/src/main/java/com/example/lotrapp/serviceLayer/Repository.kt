package com.example.lotrapp.serviceLayer


import com.example.lotrapp.models.Quote
import com.example.lotrapp.services.network.api.RetrofitInstance.Companion.api
import com.example.lotrapp.services.persistence.database.QuoteDatabase


class Repository(
    private val quoteDatabase: QuoteDatabase
) {
    suspend fun getBooks(page: Int) = api.getBooks(page)

    suspend fun getMovies() = api.getMovies()

    suspend fun getQuotes() = api.getQuotes()

    suspend fun upsert(quote : Quote) = quoteDatabase.getQuoteDao().upsert(quote)

    fun getSavedQuotes() = quoteDatabase.getQuoteDao().getAllQuotes()

    suspend fun deleteQuote(quote: Quote) = quoteDatabase.getQuoteDao().deleteQuote(quote)

    //TODO apply paging library
//    fun fetchQuotes(): LiveData<PagingData<Quote>> {
//        // 3
//        return Pager(
//            PagingConfig(pageSize = 3, enablePlaceholders = false)
//        ) {
//            QuotesPagingSource(apiService)
//        }.liveData
//    }

}