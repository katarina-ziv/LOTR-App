package com.example.lotrapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "quotes"
)
data class Quote(
    @PrimaryKey(autoGenerate = false)
    var _id: String,
    var dialog: String? = null,
    var movie: String? = null,
    var character: String? = null,
    var liked : Boolean = false
)
