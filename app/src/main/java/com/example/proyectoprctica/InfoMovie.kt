package com.example.proyectoprctica

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InfoMovie : AppCompatActivity()  {
    private  lateinit var ImageView01: ImageView
    private  lateinit var ImageView02: ImageView
    private  lateinit var textViewTitulo01: TextView
    private  lateinit var textViewTitulo02: TextView
    private  lateinit var btnPelis: ImageButton
    private  lateinit var btnSeries: ImageButton
    private  lateinit var btnPerfil: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infomovie)
        /*
        ImageView01 = findViewById(R.id.ImageView01)
        ImageView02 = findViewById(R.id.ImageView02)
        textViewTitulo01 = findViewById(R.id.textViewTitulo01)
        textViewTitulo02 = findViewById(R.id.textViewTitulo02)*/
        btnPelis = findViewById(R.id.btnPelis)
        btnSeries = findViewById(R.id.btnSeries)
        btnPerfil = findViewById(R.id.btnPerfil)
/*
        val intent = intent
        val movieId = intent.getIntExtra("MOVIE_ID", 0) // 0 es el valor predeterminado si no se encuentra la clave
        val movieTitle = intent.getStringExtra("MOVIE_TITLE")
        val moviePoster = intent.getStringExtra("MOVIE_POSTER")
*/

        btnPelis.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PpalActivity::class.java)
            startActivity(intent)
        })

        btnSeries.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PpalActivity::class.java)
            startActivity(intent)
        })

        btnPerfil.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
        })


    }
}