package com.example.proyectoprctica

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PerfilActivity  : AppCompatActivity()  {
    private lateinit var imageView: ImageView
    private lateinit var textViewTitulo: TextView
    private lateinit var textViewTitulo2: TextView
    private lateinit var btnPelis: ImageButton
    private lateinit var btnSeries: ImageButton

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        imageView = findViewById(R.id.imageView)
        textViewTitulo = findViewById(R.id.textViewTitulo)
        textViewTitulo2 = findViewById(R.id.textViewTitulo2)
        btnPelis = findViewById(R.id.btnPelis)
        btnSeries = findViewById(R.id.btnSeries)

        btnPelis.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PpalActivity::class.java)
            startActivity(intent)
        })

        btnSeries.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PpalActivity02::class.java)
            startActivity(intent)
        })



    }
}