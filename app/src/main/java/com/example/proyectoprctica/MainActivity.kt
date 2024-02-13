package com.example.proyectoprctica

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CustomAdapter
    private lateinit var btnIniciarSesion: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion)

        recyclerView.setLayoutManager(LinearLayoutManager(this))



        // Datos de ejemplo
        val images: MutableList<Int> = ArrayList()
        images.add(R.drawable.septimosello)
        images.add(R.drawable.centautosdeldesierto)
        images.add(R.drawable.tesis)
        images.add(R.drawable.septimosello)
        images.add(R.drawable.centautosdeldesierto)
        images.add(R.drawable.tesis)



        adapter = CustomAdapter(this, images)
        recyclerView.setAdapter(adapter)

        btnIniciarSesion.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        })
    }
}

