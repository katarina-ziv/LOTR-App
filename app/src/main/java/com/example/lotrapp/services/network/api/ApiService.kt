package com.example.lotrapp.services.network.api

import com.example.lotrapp.models.BaseResponse
import com.example.lotrapp.models.Book
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("book")
    suspend fun getBooks(
        @Query("page") page : Int
    ): Response<BaseResponse<Book>>

}
