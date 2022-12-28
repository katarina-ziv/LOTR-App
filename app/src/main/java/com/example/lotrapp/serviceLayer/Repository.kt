package com.example.lotrapp.serviceLayer

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.lotrapp.models.Quote
import com.example.lotrapp.services.network.api.ApiService
import com.example.lotrapp.services.network.api.RetrofitInstance
import com.example.lotrapp.services.network.api.RetrofitInstance.Companion.api
import kotlinx.coroutines.flow.Flow

class Repository {
    private val apiService = api
    suspend fun getBooks(page: Int) = RetrofitInstance.api.getBooks(page)

    suspend fun getMovies() = RetrofitInstance.api.getMovies()

    suspend fun getQuotes() = RetrofitInstance.api.getQuotes()

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