package com.example.androidweek_4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class doSignUp : ViewModel()
{
    private var _isSuccessEvent: MutableLiveData<Boolean> = MutableLiveData()
    val isSuccessEvent: LiveData<Boolean>
        get() = _isSuccessEvent

    private var _isErrorEvent: MutableLiveData<String> = MutableLiveData()
    val isErrorEvent: LiveData<String>
        get() = _isErrorEvent
    fun checkEmailAndPassword(email: String, password: String)
    {
        val isValidEmail = isEmailValid(email)
        val isValidPassword = isPasswordValid(password)
        if (!isValidEmail) {
            _isErrorEvent.postValue("Email không hợp lệ")
            return
        }
        if (!isValidPassword) {
            _isErrorEvent.postValue("Password phải ít nhất 8 kí tự có chữ hoa, chữ thường, số, và các ký tự sau: ! @ # $ % ^ & * ( )")
            return
        }
        _isSuccessEvent.postValue(true)
    }

    private fun isEmailValid(email: String): Boolean {
        if (".com" in email)
        {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }
        return false
    }

    private fun isPasswordValid(password: String): Boolean {
        val upperRegex = Regex("[A-Z]")
        val numberRegex = Regex("\\d")
        val specialRegex = Regex("[^A-Za-z0-9]")

        val hasUpper = upperRegex.find(password) != null
        val hasNumber = numberRegex.find(password) != null
        val hasSpecial = specialRegex.find(password) != null

        return hasUpper && hasNumber && hasSpecial && password.length >= 8
    }

}