package com.example.lotrapp.models

data class Movie(
    var _id: String,
    var name: String,
    var runtimeInMinutes: Int?,
    var rottenTomatoesScore: Double?
)
