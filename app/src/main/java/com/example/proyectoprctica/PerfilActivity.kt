package com.example.proyectoprctica

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
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
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var ajustes: ImageButton
    private lateinit var milinearLayout: View
    private lateinit var milinearLayout2: View

    val pickMedia =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            if (uri != null) {
                imageView.setImageURI(uri)
            }
        }

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


        //CAMERA BUTTON
        btn1.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, 1)
            }
        }

        //GALLERY BUTTON
       btn2.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
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

        ajustes.setOnClickListener {

            // Cambiar la visibilidad de las vistas
            if (milinearLayout.visibility == View.VISIBLE) {
                milinearLayout.visibility = View.GONE
                milinearLayout2.visibility = View.VISIBLE
            }
        }
        btn3.setOnClickListener {
            finishAffinity();
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }




    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val extras = data?.extras
            val imgBitmap: Bitmap = extras?.get("data") as Bitmap
            imageView.setImageBitmap(imgBitmap)
        }
    }
}