package com.example.alif_3tia_mobile

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alif_3tia_mobile.Pertemuan5.LimaActivity
import com.example.alif_3tia_mobile.databinding.ActivityLogin2Binding
import com.example.alif_3tia_mobile.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val user = intent.getStringExtra("username")
        val pass= intent.getStringExtra("password")

        binding.textView3.text =user
        binding.textView4.text =pass

        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(
                binding.root, "Halo ini Snackbar",
                Snackbar.LENGTH_LONG
            )
                .setAction("Info") {
                    // kembalikan item
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Kembali ke Halaman Activity", Toast.LENGTH_LONG).show()
                }
                .show()

        }
        binding.btnAlert.setOnClickListener { MaterialAlertDialogBuilder(this)
            .setTitle("Hapus data")
            .setMessage("Data Tidak Bisa di Kembalikan")
            .setNegativeButton("Batal", null)
            .setPositiveButton("Hapus") { dialog, _ ->
                // proses hapus
                dialog.dismiss()
            }
            .setCancelable(false)
            .show() }
        binding.btnlima.setOnClickListener {
            val intent = Intent(this, LimaActivity::class.java)
            startActivity(intent)
        }
    }



}
