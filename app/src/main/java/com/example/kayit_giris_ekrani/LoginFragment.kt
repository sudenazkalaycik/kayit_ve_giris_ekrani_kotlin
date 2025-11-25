package com.example.kayit_giris_ekrani

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kayit_giris_ekrani.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val inputName = binding.etLoginName.text.toString()
            val inputPass = binding.etLoginPassword.text.toString()

            val pref = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val savedName = pref.getString("NAME", "")
            val savedSurname = pref.getString("SURNAME", "")
            val savedPass = pref.getString("PASS", "")
            val savedColor = pref.getString("COLOR", "white")

            if (inputName == savedName && inputPass == savedPass) {
                val intent = Intent(requireContext(), WelcomeActivity::class.java)
                intent.putExtra("FULLNAME", "$savedName $savedSurname")
                intent.putExtra("COLOR", savedColor)
                startActivity(intent)
            } else {
                Toast.makeText(context, "Hatalı Bilgi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}