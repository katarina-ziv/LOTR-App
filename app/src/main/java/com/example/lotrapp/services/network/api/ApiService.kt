package com.example.lotrapp.services.network.api

import com.example.lotrapp.models.Book
import com.example.lotrapp.models.BookResponse
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET("book")
    suspend fun getBooks(): Response<BookResponse>

}
