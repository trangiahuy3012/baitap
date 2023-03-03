package com.example.androidweek_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class OnboardActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard3)

        val next3:ImageButton= findViewById(R.id.next3)
        next3.setOnClickListener{ swip() }


    }
    fun swip()
    {
        val intent: Intent = Intent(this, WelcomeActivity::class.java)
        startActivity(intent)
    }
}