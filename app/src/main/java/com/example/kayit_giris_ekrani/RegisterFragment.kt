package com.example.kayit_giris_ekrani

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
// Aşağıdaki import paket ismine göre değişebilir, kırmızı yanarsa silip tekrar import et
import com.example.kayit_giris_ekrani.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnKaydet.setOnClickListener {
            val name = binding.etName.text.toString()
            val surname = binding.etSurname.text.toString()
            val pass = binding.etPassword.text.toString()
            val color = binding.etColor.text.toString().lowercase().trim()

            val sharedPref = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("NAME", name)
            editor.putString("SURNAME", surname)
            editor.putString("PASS", pass)
            editor.putString("COLOR", color)
            editor.apply()

            Toast.makeText(context, "Kayıt Başarılı! Giriş yapabilirsiniz.", Toast.LENGTH_SHORT).show()
        }
    }
}