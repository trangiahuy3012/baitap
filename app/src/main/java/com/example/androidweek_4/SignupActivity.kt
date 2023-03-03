package com.example.androidweek_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.androidweek_4.databinding.SignupLayoutBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: SignupLayoutBinding

    private lateinit var ViewModel:doSignUp
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.signup_layout)

        binding.signupButton.setOnClickListener {signup_lientay()}
        ViewModel = ViewModelProvider(this).get(doSignUp::class.java)

        listenerSuccessEvent()
        listenerErrorEvent()
    }

    fun signup_lientay()
    {
        val email_signup:String = binding.newEmailInput.text.toString().trim()
        val password_signup:String = binding.newPasswordInput.text.toString().trim()
        ViewModel.checkEmailAndPassword(email_signup, password_signup)
    }

    private fun listenerSuccessEvent() {
        ViewModel.isSuccessEvent.observe(this) { isSuccess ->
            if (isSuccess) {
                val email = binding.newEmailInput.text.toString().trim()
                val password = binding.newPasswordInput.text.toString().trim()
                val intent = Intent(this, ProfileActivity::class.java)
                val bundle = Bundle()
                bundle.putParcelable(Constants.KEY_USER, Student(email, password))
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    private fun listenerErrorEvent() {
        ViewModel.isErrorEvent.observe(this) { errMsg ->
            Toast.makeText(this, errMsg, Toast.LENGTH_SHORT).show()
        }
    }
}