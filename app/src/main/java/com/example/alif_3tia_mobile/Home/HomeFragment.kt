package com.example.alif_3tia_mobile.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.alif_3tia_mobile.Home.Pertemuan5.LimaActivity
import com.example.alif_3tia_mobile.Home.Pertemuan6.EnamActivity
import com.example.alif_3tia_mobile.Home.Pertemuan_9.NinthActivity
import com.example.alif_3tia_mobile.LoginActivity2
import com.example.alif_3tia_mobile.MainActivity
import com.example.alif_3tia_mobile.R
import com.example.alif_3tia_mobile.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.ToolBar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Home"
        super.onViewCreated(view, savedInstanceState)
        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)
        val user = requireActivity().intent.getStringExtra("username")
        val pass = requireActivity().intent.getStringExtra("password")

        binding.textView3.text = user
        binding.textView4.text = pass

        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(
                binding.root, "Halo ini Snackbar",
                Snackbar.LENGTH_LONG
            )
                .setAction("Info") {
                    // kembalikan item
                    val intent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(
                        requireContext(),
                        "Kembali ke Halaman Activity",
                        Toast.LENGTH_LONG
                    ).show()
                }
                .show()

        }
        binding.btnAlert.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Hapus data")
                .setMessage("Data Tidak Bisa di Kembalikan")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Hapus") { dialog, _ ->
                    // proses hapus
                    dialog.dismiss()
                }
                .setCancelable(false)
                .show()
        }
        binding.btnlima.setOnClickListener {
            val intent = Intent(requireContext(), LimaActivity::class.java)
            startActivity(intent)
        }
        binding.btnEnam.setOnClickListener {
            val intent = Intent(requireContext(), EnamActivity::class.java)
            startActivity(intent)

        }
        binding.btnP9.setOnClickListener {
            val intent = Intent(requireContext(), NinthActivity::class.java)
            startActivity(intent)
        }
            binding.btnLogout.setOnClickListener {
                AlertDialog.Builder(requireContext())
                    .setTitle("Login Gagal")
                    .setMessage("Silahkan coba lagi")
                    .setPositiveButton("Ya") { dialog, _ ->
                        val editor = sharedPref.edit()
                        editor.clear()
                        editor.apply()
                        dialog.dismiss()
                        startActivity(Intent(requireContext(), LoginActivity2::class.java))
                        requireActivity().finish()
                    }
                    .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                    .show()
            }
        }
    }




