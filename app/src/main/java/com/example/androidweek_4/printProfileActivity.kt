package com.example.androidweek_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class printProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_print_profile)

        val name:TextView = findViewById(R.id.final_name)
        val email:TextView = findViewById(R.id.final_email)
        val number:TextView = findViewById(R.id.final_number)
        val bundle = intent.extras
        bundle?.let {
            val new_fullname = bundle.getString("name", "unknown")
            val new_email = bundle.getString("mail", "unknown")
            val new_number = bundle.getString("num", "unknown")
            name.text = new_fullname
            email.text = new_email
            number.text = new_number
        }

    }
}