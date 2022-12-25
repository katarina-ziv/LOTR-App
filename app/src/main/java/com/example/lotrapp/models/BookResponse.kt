package com.example.lotrapp.models

data class BookResponse(
    val books: List<Book>,
    val limit: Int,
    val offset: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)