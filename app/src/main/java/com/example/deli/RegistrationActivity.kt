package com.example.deli

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide


class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regestration)

        val imageView = findViewById<ImageView>(R.id.gifKa)

        Glide.with(this)
            .load(R.drawable.email)
            .into(imageView)

        val next_btn = findViewById<Button>(R.id.next_registration_button)
        next_btn.setOnClickListener {
            val intent = Intent(this@RegistrationActivity, MainMenuActivity::class.java)
            startActivity(intent)
        }
    }
}