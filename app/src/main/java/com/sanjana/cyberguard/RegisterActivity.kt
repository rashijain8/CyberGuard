package com.sanjana.cyberguard

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var tvPasswordStrength: TextView
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        tvPasswordStrength = findViewById(R.id.tvPasswordStrength)
        btnRegister = findViewById(R.id.btnRegister)

        // Password strength checker
        etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val password = s.toString()
                val strength = getPasswordStrength(password)
                tvPasswordStrength.text = strength
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        // Register button logic
        btnRegister.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()

            if (!isValidEmail(email)) {
                etEmail.error = "Please enter a valid email address"
            } else if (password.length < 6) {
                etPassword.error = "Password must be at least 6 characters"
            } else {
                Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
                // Proceed with saving user data or moving to another activity
            }
        }
    }

    private fun getPasswordStrength(password: String): String {
        val length = password.length
        val hasUpper = password.any { it.isUpperCase() }
        val hasLower = password.any { it.isLowerCase() }
        val hasDigit = password.any { it.isDigit() }
        val hasSpecial = password.any { "!@#\$%^&*()-_+=<>?/".contains(it) }

        return when {
            length < 6 -> "Weak 🔴 (Use at least 6 characters)"
            length < 8 || !(hasUpper && hasDigit && hasSpecial) -> "Medium 🟠 (Try adding numbers, symbols, or capital letters)"
            else -> "Strong 🟢"
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
