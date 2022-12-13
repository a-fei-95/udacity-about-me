package com.example.aboutme

import android.content.Context
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.example.aboutme.databinding.ActivityMainBinding
import com.google.android.material.internal.ViewUtils.hideKeyboard

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName = MyName("Steven Yang")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.myName = myName
        binding.addNickname()

        setContentView(binding.root)
    }

    private fun ActivityMainBinding.addNickname() {
        doneButton.setOnClickListener {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            doneButton.isGone = true
            nicknameEdit.isGone = true
            nicknameText.isVisible = true
        }
        hideKeyboard()
    }

    private fun ActivityMainBinding.hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(root.windowToken, 0)
    }
}