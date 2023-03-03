package com.example.androidweek_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidweek_4.databinding.ActivityProfileBinding
class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var viewModel: doProfile
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        viewModel = ViewModelProvider(this).get(doProfile::class.java)

        val bundle = intent.extras
        bundle?.let {
            val student : Student? = it.getParcelable(Constants.KEY_USER)
            student?.let {
                binding.newEmailInput.setText("${student.username}")
            }
        }

        binding.signupButton.setOnClickListener { signupEnter() }
    }

    private fun signupEnter()
    {
        val new_fullname: String = binding.newName.text.toString().trim() //findViewById(R.id.new_name)
        val new_email: String = binding.newEmailInput.text.toString().trim()//findViewById(R.id.new_email_input)
        val new_number: String = binding.newNumber.text.toString().trim()//findViewById(R.id.new_number)

        val bundle = Bundle()
        bundle.putString("name", new_fullname)
        bundle.putString("mail", new_email)
        bundle.putString("num", new_number)
        val intent: Intent = Intent(this, printProfileActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}