package com.example.praktikum_07_sharedpreferences

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.praktikum_07_sharedpreferences.DB.DBHelper

class RegisterActivity : AppCompatActivity() {
    private lateinit var eemail: EditText
    private lateinit var epassword: EditText
    private lateinit var efullname: EditText
    private lateinit var btnregister: Button
    private lateinit var btncancel: Button
    private lateinit var userDBHelper: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        eemail = findViewById(R.id.EditEmailRegister)
        epassword = findViewById(R.id.EditPasswordRegister)
        efullname= findViewById(R.id.EditFullnameRegister)
        btnregister = findViewById(R.id.btnsubmitregister)
        btncancel = findViewById(R.id.btncancelregister)
        userDBHelper = DBHelper(this)
    }
    fun registerme(view: View){
        val iemail = eemail.text.toString()
        val ipassword = epassword.text.toString()
        val ifullname = efullname.text.toString()

        val cekuser = userDBHelper.cekUser(iemail)
        var status = "Gagal"
        if (cekuser =="0") {
            userDBHelper.RegisterUser(iemail, ipassword, ifullname)
            status = "Sukses"
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
        val toast: Toast = Toast.makeText(applicationContext,
            status, Toast.LENGTH_SHORT)
        toast.show()
    }
    fun cancelme(view: View){
        startActivity(Intent(this, LoginActivity::class.java))
    }
}