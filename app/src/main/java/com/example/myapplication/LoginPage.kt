package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class LoginPage : AppCompatActivity() {

    private val sharedPrefFile = "kotlinsharedpreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)

        val btnLogin = findViewById<Button>(R.id.loginButton)
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,
            Context.MODE_PRIVATE)
        btnLogin.setOnClickListener(View.OnClickListener {
            val uname:String = username.text.toString()
            val pass:String = password.text.toString()
            if(uname=="admin" && pass=="admin") {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("uname_key", uname)
                editor.putString("pass_key", pass)
                editor.apply()
                editor.commit()
                Toast.makeText(this,"Login Successfully!",Toast.LENGTH_SHORT).show()
                val listDetailIntent = Intent(this, HomePage::class.java)
                startActivity(listDetailIntent)
            }
            else{
                Toast.makeText(this,"Login Failed!",Toast.LENGTH_SHORT).show()
            }
        })
    }
}