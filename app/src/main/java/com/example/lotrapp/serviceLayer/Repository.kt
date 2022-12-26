package com.example.lotrapp.serviceLayer

import com.example.lotrapp.services.network.api.RetrofitInstance

class Repository {

    suspend fun getBooks(page: Int) = RetrofitInstance.api.getBooks(page)

    suspend fun getMovies(token : String) = RetrofitInstance.api.getMovies(token)

}