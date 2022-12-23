package com.example.lotrapp.services.persistence

import android.content.Context
import com.example.lotrapp.BuildConfig

class SharedPreferences(private val context : Context) {

    private val prefs = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
    var username : String
        get() = prefs.getString(USERNAME,"")?: ""
        set(value) = prefs.edit().putString(USERNAME,value).apply()

    companion object{
        private const val PREF = "myPrefs"
        private const val USERNAME = "USERNAME"
        private const val API_KEY = BuildConfig.API_KEY
        //TODO - API KEY
    }
}