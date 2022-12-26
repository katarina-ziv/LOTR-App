package com.example.lotrapp.services.network.api

import com.example.lotrapp.models.BaseResponse
import com.example.lotrapp.models.Book
import com.example.lotrapp.models.Movie
import com.example.lotrapp.services.utils.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface ApiService {
    @GET("book")
    suspend fun getBooks(
        @Query("page") page : Int
    ): Response<BaseResponse<Book>>

    @GET("movie/")
    suspend fun getMovies(
        @Header("Authorization")
        apiKey: String = API_KEY
    ): Response<BaseResponse<Movie>>

}
