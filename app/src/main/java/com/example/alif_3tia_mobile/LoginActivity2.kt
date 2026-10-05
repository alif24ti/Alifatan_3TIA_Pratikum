package com.example.alif_3tia_mobile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alif_3tia_mobile.databinding.ActivityLogin2Binding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class LoginActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityLogin2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        setContentView(R.layout.activity_login2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        val TombolLogin : Button = findViewById(R.id.btnLogin)
//        val username : EditText = findViewById(R.id.edtUsername)
//        val password: EditText = findViewById(R.id.edtPassword)


        binding.btnLogin.setOnClickListener {
            val user = binding.edtUsername.text.toString()
            val pass = binding.edtPassword.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("username", user)
            intent.putExtra("password", pass)

            startActivity(intent)

            Log.d("Output", "Username $user Password $pass")
            Toast.makeText(this, "Username: $user Password: $pass", Toast.LENGTH_LONG).show()
        }

    }
}
