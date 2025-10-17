package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        // Botón de Login
        binding.loginButton.setOnClickListener {
            if (validateLoginForm()) {
                loginUser()
            }
        }

        // Botón "Regístrate"
        binding.registerLinkButton.setOnClickListener {
            navigateToRegister()
        }

        // Botón de Google
        binding.googleButton.setOnClickListener {
            signInWithGoogle()
        }

        // Botón de Facebook (nuevo)
        binding.facebookButton.setOnClickListener {
            signInWithFacebook()
        }
    }

    private fun validateLoginForm(): Boolean {
        val email = binding.emailEditText.text.toString().trim()
        val password = binding.passwordEditText.text.toString()

        var isValid = true

        if (email.isEmpty()) {
            binding.emailInputLayout.error = "El email es requerido"
            isValid = false
        } else {
            binding.emailInputLayout.error = null
        }

        if (password.isEmpty()) {
            binding.passwordInputLayout.error = "La contraseña es requerida"
            isValid = false
        } else {
            binding.passwordInputLayout.error = null
        }

        return isValid
    }

    private fun loginUser() {
        val email = binding.emailEditText.text.toString().trim()

        Toast.makeText(this, "Login exitoso: $email", Toast.LENGTH_SHORT).show()


    }

    private fun signInWithGoogle() {
        // Aquí iría la integración con Google Sign-In
        Toast.makeText(this, "Iniciar con Google", Toast.LENGTH_SHORT).show()
    }

    private fun signInWithFacebook() {
        // Aquí iría la integración con Facebook Sign-In
        Toast.makeText(this, "Iniciar con Facebook", Toast.LENGTH_SHORT).show()
    }

    private fun navigateToRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}