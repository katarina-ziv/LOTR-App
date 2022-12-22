package com.example.lotrapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lotrapp.databinding.ActivityInitialBinding

class InitialActivity : AppCompatActivity() {

    private lateinit var binding : ActivityInitialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInitialBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var username = binding.nameEditText.text


        binding.enterButton.setOnClickListener {
            if (username!!.isEmpty()) {
                Toast.makeText(this, "You shall not pass! Enter a username", Toast.LENGTH_SHORT)
                    .show()
            } else {
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }
    }
}