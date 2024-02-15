package com.example.proyectoprctica

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PpalActivity02 : AppCompatActivity() {
    private lateinit var adapter: CustomAdapter02
    private lateinit var btnPelis: ImageButton
    private lateinit var btnPerfil: ImageButton
    private lateinit var Imagen: ImageView
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ppal)


        Log.d(ContentValues.TAG, "asignacion al layout")
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView2)
        btnPelis = findViewById(R.id.btnPelis)
        btnPerfil = findViewById(R.id.btnPerfil)
        Imagen = findViewById(R.id.ImageView04)
        Log.d(ContentValues.TAG, "asignacion al recycleview")
        Imagen.setImageResource(R.drawable._2a20a8e36f35);


        Log.d(ContentValues.TAG, "Define las listas de datos para los RecyclerViews internos")
        val dataLists: List<List<Int>> = listOf(
            listOf(R.drawable.septimosello),
            listOf(R.drawable.centautosdeldesierto, R.drawable.septimosello),
            listOf(R.drawable.centautosdeldesierto, R.drawable.septimosello),
            listOf(R.drawable.centautosdeldesierto, R.drawable.septimosello),
            listOf(R.drawable.centautosdeldesierto, R.drawable.septimosello),
            // Agrega más listas según sea necesario
        )



        Log.d(ContentValues.TAG, "Crea una instancia de tu adaptador y configúralo en el RecyclerView principal")

        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = CustomAdapter02(this, dataLists)
        recyclerView.setAdapter(adapter)
        //recyclerView.layoutManager = LinearLayoutManager(this)

        btnPelis.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PpalActivity::class.java)
            startActivity(intent)
        })

        btnPerfil.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
        })



    }
}