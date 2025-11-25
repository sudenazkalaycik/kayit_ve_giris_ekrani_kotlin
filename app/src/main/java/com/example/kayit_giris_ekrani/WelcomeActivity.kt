package com.example.kayit_giris_ekrani

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kayit_giris_ekrani.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fullName = intent.getStringExtra("FULLNAME")
        val colorName = intent.getStringExtra("COLOR")

        binding.tvWelcome.text = "Hoş geldiniz, $fullName"

        val bgColor = when(colorName) {
            "red", "kırmızı" -> Color.RED
            "green", "yeşil" -> Color.GREEN
            "blue", "mavi" -> Color.BLUE
            else -> Color.LTGRAY
        }
        binding.mainRoot.setBackgroundColor(bgColor)
    }
}