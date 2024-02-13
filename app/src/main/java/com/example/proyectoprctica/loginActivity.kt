package com.example.proyectoprctica

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase


class loginActivity  : AppCompatActivity() {
    //VARIABLES
    private lateinit var Email : EditText
    private lateinit var Password : EditText
    private lateinit var btnIniciarSesion: Button
    private lateinit var btnCrearCuenta: Button
    private lateinit var btnVolver: Button
    private lateinit var textViewWarning: TextView
    //private lateinit var auth: FirebaseAuth
    //private lateinit var auth: FirebaseAuth



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Email = findViewById(R.id.editTextEmail)
        Password = findViewById(R.id.editTextPassword)
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion)
        btnCrearCuenta = findViewById(R.id.btnIniciarSesion)
        btnVolver = findViewById(R.id.btnVolver)

        //auth = Firebase.auth

        btnIniciarSesion.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PpalActivity::class.java)
            startActivity(intent)
        })
        btnVolver.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })

    }



}