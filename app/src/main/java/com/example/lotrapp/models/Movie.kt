package com.example.lotrapp.models

import com.example.lotrapp.R
import java.io.Serializable

data class Movie(
    var _id: String,
    var name: String,
    var runtimeInMinutes: Int?,
    var budgetInMillions: Int?,
    var academyAwardNominations: Int?,
    var academyAwardWins: Int?,
    var rottenTomatoesScore: Double?,
    var image : Int?,
    var backgroundImage: Int?,
    var description : String?
) : Serializable
