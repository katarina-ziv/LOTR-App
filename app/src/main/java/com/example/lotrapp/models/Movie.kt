package com.example.lotrapp.models

data class Movie(
    var _id: String,
    var name: String,
    var runtimeInMinutes: Int?,
    var budgetInMillions: Int?,
    var academyAwardNominations: Int?,
    var academyAwardWins: Int?,
    var rottenTomatoesScore: Double?,
    var image : String?,
    var backgroundImage: String?,
    var description : String?
)
