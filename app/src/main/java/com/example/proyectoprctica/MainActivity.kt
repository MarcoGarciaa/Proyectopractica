package com.example.proyectoprctica

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.setLayoutManager(LinearLayoutManager(this))



        // Datos de ejemplo
        val images: MutableList<Int> = ArrayList()
        images.add(R.drawable.onceuponatime)
        images.add(R.drawable.onceuponatime)
        images.add(R.drawable.onceuponatime)
        adapter = CustomAdapter(this, images)
        recyclerView.setAdapter(adapter)
    }
}

