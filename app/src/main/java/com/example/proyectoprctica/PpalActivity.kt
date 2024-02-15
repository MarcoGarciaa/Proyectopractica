package com.example.proyectoprctica


import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

import java.io.IOException

import okhttp3.*



class PpalActivity : AppCompatActivity() {
    private lateinit var adapter: CustomAdapter02
    private lateinit var btnSeries: ImageButton
    private lateinit var btnPerfil: ImageButton
    private lateinit var Imagen: ImageView



    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ppal)


        Log.d(TAG, "asignacion al layout")
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView2)
        val btnSeries: ImageButton = findViewById(R.id.btnSeries)
        val btnPerfil: ImageButton = findViewById(R.id.btnPerfil)
        Imagen = findViewById(R.id.ImageView04)
        Log.d(TAG, "asignacion al recycleview")




        Imagen.setImageResource(R.drawable.crack);
        Log.d(TAG, "Define las listas de datos para los RecyclerViews internos")
        val dataLists: List<List<Int>> = listOf(
            listOf(R.drawable.septimosello),
            listOf(R.drawable.centautosdeldesierto, R.drawable.septimosello,R.drawable.centautosdeldesierto, R.drawable.septimosello),
            listOf(R.drawable.centautosdeldesierto, R.drawable.septimosello,R.drawable.centautosdeldesierto, R.drawable.septimosello),
            listOf(R.drawable.centautosdeldesierto, R.drawable.septimosello),
            listOf(R.drawable.centautosdeldesierto, R.drawable.septimosello),
            // Agrega más listas según sea necesario
        )



        Log.d(TAG, "Crea una instancia de tu adaptador y configúralo en el RecyclerView principal")

        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = CustomAdapter02(this, dataLists)
        recyclerView.setAdapter(adapter)
        //recyclerView.layoutManager = LinearLayoutManager(this)

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