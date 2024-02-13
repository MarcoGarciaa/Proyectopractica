package com.example.proyectoprctica

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

import okhttp3.*



class PpalActivity : AppCompatActivity() {
    private lateinit var adapter: CustomAdapter02


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ppal)


        Log.d(TAG, "asignacion al layout")
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView2)
        Log.d(TAG, "asignacion al recycleview")






        Log.d(TAG, "Define las listas de datos para los RecyclerViews internos")
        val dataLists: List<List<Int>> = listOf(
            listOf(R.drawable.septimosello),
            listOf(R.drawable.centautosdeldesierto, R.drawable.septimosello),
            listOf(R.drawable.centautosdeldesierto, R.drawable.septimosello),
            listOf(R.drawable.centautosdeldesierto, R.drawable.septimosello),
            listOf(R.drawable.centautosdeldesierto, R.drawable.septimosello),
            // Agrega más listas según sea necesario
        )



        Log.d(TAG, "Crea una instancia de tu adaptador y configúralo en el RecyclerView principal")

        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = CustomAdapter02(this, dataLists)
        recyclerView.setAdapter(adapter)
        //recyclerView.layoutManager = LinearLayoutManager(this)




        Log.d(TAG, "FIN??")
    }
}