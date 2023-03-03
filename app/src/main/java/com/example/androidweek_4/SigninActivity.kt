package com.example.androidweek_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidweek_4.databinding.SigninLayoutBinding

class SigninActivity : AppCompatActivity() {
    private lateinit var binding: SigninLayoutBinding
    private lateinit var viewModel: doSignin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.signin_layout)
        viewModel = ViewModelProvider(this).get(doSignin::class.java)
        
        //val loginButton: Button = findViewById(R.id.login_button)
        binding.loginButton.setOnClickListener{ login() }
        //val signupButton:TextView = findViewById(R.id.signup_link)
        binding.signupLink.setOnClickListener { signup() }

        listenerSuccessEvent()
        listenerErrorEvent()
    }

    private fun login()
    {
        val user_signin = binding.emailInput.text.toString().trim()
        val password_signin = binding.passwordInput.text.toString().trim()
        viewModel.checkEmailAndPassword(user_signin, password_signin)
    }

    private fun signup()
    {
        val intent: Intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }

    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(this) { isSuccess ->
            if (isSuccess) {
                val email = binding.emailInput.text.toString().trim()
                val password = binding.passwordInput.text.toString().trim()
                val intent = Intent(this, Restaurant_rv::class.java)
                val bundle = Bundle()
                bundle.putParcelable(Constants.KEY_USER, Student(email, password))
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    private fun listenerErrorEvent() {
        viewModel.isErrorEvent.observe(this) { errMsg ->
            Toast.makeText(this, errMsg, Toast.LENGTH_SHORT).show()
        }
    }
}