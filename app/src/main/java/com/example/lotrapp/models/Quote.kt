package com.example.lotrapp.models

data class Quote(
    var _id: String,
    var dialog: String? = null,
    var movie: String? = null,
    var character: String? = null
)
