package com.example.lotrapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.lotrapp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val username = sharedPreferences.getString("username","")

        Handler(Looper.getMainLooper()).postDelayed({
            if(username!!.isEmpty()){
                val initialIntent = Intent(this,InitialActivity::class.java)
                startActivity(initialIntent)
            }else{
                val mainIntent = Intent(this,MainActivity::class.java)
                startActivity(mainIntent)
            }
            finish()
        }, 1500)
    }

}