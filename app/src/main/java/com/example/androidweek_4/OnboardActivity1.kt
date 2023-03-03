package com.example.androidweek_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class OnboardActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard1)

        val next1:ImageButton= findViewById(R.id.next1)
        next1.setOnClickListener{ swip() }


    }
    fun swip()
    {
        val intent: Intent = Intent(this, OnboardActivity2::class.java)
        startActivity(intent)
    }
}