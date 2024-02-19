package com.example.proyectoprctica

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore

class PerfilActivity  : AppCompatActivity()  {
    private lateinit var imageView: ImageView
    private lateinit var textViewTitulo: TextView
    private lateinit var textViewTitulo2: TextView
    private lateinit var textViewTitulo3: com.google.android.material.textfield.TextInputEditText
    private lateinit var btnPelis: ImageButton
    private lateinit var btnSeries: ImageButton
    private lateinit var btn1: ImageButton
    private lateinit var btn2: ImageButton
    private lateinit var btn3: ImageButton
    private lateinit var ajustes: Button
    private lateinit var milinearLayout: View
    private lateinit var milinearLayout2: View

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        imageView = findViewById(R.id.imageView)
        textViewTitulo = findViewById(R.id.textViewTitulo)
        textViewTitulo2 = findViewById(R.id.textViewTitulo2)
        textViewTitulo3 = findViewById(R.id.textViewTitulo3)
        btnPelis = findViewById(R.id.btnPelis)
        btnSeries = findViewById(R.id.btnSeries)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        ajustes = findViewById(R.id.ajustes)
        milinearLayout = findViewById(R.id.milinearLayout)
        milinearLayout2 = findViewById(R.id.milinearLayout2)


        val db = FirebaseFirestore.getInstance()
        db.collection("Users").document(GlobalVariables.id).get().addOnSuccessListener {

            textViewTitulo.text = "Nombre: "+ it.get("Name") as String?
            textViewTitulo2.text = "Mail: "+ it.get("Gmail") as String?
            textViewTitulo3.setText( it.get("Contraseña") as String?)

        }



        btnPelis.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PpalActivity::class.java)
            startActivity(intent)
        })

        btnSeries.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PpalActivity::class.java)
            startActivity(intent)
        })

        ajustes.setOnClickListener {

            // Cambiar la visibilidad de las vistas
            if (milinearLayout.visibility == View.VISIBLE) {
                milinearLayout.visibility = View.GONE
                milinearLayout2.visibility = View.VISIBLE
            }
        }

        btn1.setOnClickListener {

            // Cambiar la visibilidad de las vistas
            if (milinearLayout.visibility == View.VISIBLE) {
                milinearLayout.visibility = View.GONE
                milinearLayout2.visibility = View.VISIBLE
            }
        }


    }
}