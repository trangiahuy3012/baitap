package com.example.androidweek_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class OnboardActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard2)

        val next2:ImageButton= findViewById(R.id.next2)
        next2.setOnClickListener{ swip() }


    }
    fun swip()
    {
        val intent: Intent = Intent(this, OnboardActivity3::class.java)
        startActivity(intent)
    }
}