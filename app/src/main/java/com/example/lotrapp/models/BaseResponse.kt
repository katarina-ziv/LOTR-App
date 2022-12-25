package com.example.lotrapp.models

data class BaseResponse<T>(
    val docs: List<T>,
    val limit: Int,
    val offset: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)