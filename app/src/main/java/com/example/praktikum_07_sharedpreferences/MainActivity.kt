package com.example.praktikum_07_sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnLogout: Button = findViewById(R.id.btnLogout)
        val savedLogin = getSharedPreferences("Login", MODE_PRIVATE) //akses shared preference
        val editSavedLogin = savedLogin.edit() //untuk edit data yang tersimpan

        //jika button logout di klik maka dilakukan penyimpanan perubahan data dan menuju halaman login
        btnLogout.setOnClickListener {
            editSavedLogin.putString("Email", null)
            editSavedLogin.putString("Password", null)
            editSavedLogin.putString("Status", "Off")
            editSavedLogin.apply()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}