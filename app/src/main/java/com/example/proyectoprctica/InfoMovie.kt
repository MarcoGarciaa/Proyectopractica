package com.example.proyectoprctica

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import kotlin.math.round

class InfoMovie : AppCompatActivity()  {
    private  lateinit var ImageView01: ImageView
    private  lateinit var ImageView02: ImageView
    private  lateinit var textViewTitulo01: TextView
    private  lateinit var textViewTitulo02: TextView
    private  lateinit var btnPelis: ImageButton
    private  lateinit var btnSeries: ImageButton
    private  lateinit var btnPerfil: ImageButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infomovie)

        ImageView01 = findViewById(R.id.ImageView01)
        ImageView02 = findViewById(R.id.ImageView02)
        textViewTitulo01 = findViewById(R.id.textViewTitulo01)
        textViewTitulo02 = findViewById(R.id.textViewTitulo02)
        btnPelis = findViewById(R.id.btnPelis)
        btnSeries = findViewById(R.id.btnSeries)
        btnPerfil = findViewById(R.id.btnPerfil)

        val estrellas = puntuacion(this, 5.0) // Cambia 3.5 por la puntuación real
        val imageViews = listOf<ImageView>(findViewById(R.id.star1), findViewById(R.id.star2), findViewById(R.id.star3), findViewById(R.id.star4), findViewById(R.id.star5))

        for (i in 0 until 5) {
            imageViews[i].setImageDrawable(estrellas[i])
        }

        val intent = intent
        val imagen1 = intent.getIntExtra("MOVIE_FHOTO2", 0)
        val imagen2 = intent.getIntExtra("MOVIE_FHOTO", 0)
        val nombre = intent.getStringExtra("MOVIE_NAME")
        val puntuacion = intent.getStringExtra("MOVIE_RATE")
        val resumen = intent.getStringExtra("MOVIE_RESUMEN")
        val url = intent.getStringExtra("MOVIE_URL")



        ImageView01.setImageResource(imagen1)
        ImageView02.setImageResource(imagen2)
        textViewTitulo01.text = nombre.toString()
        textViewTitulo02.text = resumen.toString()






        val buttonGoToGoogle: Button = findViewById(R.id.trailer)
        // Habilitar JavaScript (necesario para algunos sitios web, incluido YouTube)
        buttonGoToGoogle.setOnClickListener {
            val uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }


        Log.d(ContentValues.TAG, "00?? "+imagen1)



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
    fun puntuacion(context: Context, nota: Double): Array<Drawable?> {

        val estrellasLlenas = (round(nota).toInt() / 2)
        Log.d(ContentValues.TAG, "estrellas: "+estrellasLlenas)
        Log.d(ContentValues.TAG, "estrellas: "+round(nota))

        val estrellaMitad = nota % 2
        Log.d(ContentValues.TAG, "estrellas: "+estrellaMitad)

        val drawableStar = AppCompatResources.getDrawable(context, R.drawable.baseline_star_rate_24)
        val drawableMediaStar = AppCompatResources.getDrawable(context, R.drawable.baseline_star_half_24)
        val drawableVaciaStar = AppCompatResources.getDrawable(context, R.drawable.baseline_star_outline_24)

        val estrellas = arrayOfNulls<Drawable>(5)
        estrellas[0] = drawableStar
        estrellas[1] = drawableStar

        for (i in 0..estrellasLlenas-1) {
            estrellas[i] = drawableStar
        }
        for (i in 0..(estrellaMitad-1).toInt()) {
            estrellas[estrellasLlenas+i] = drawableMediaStar
        }
        for (i in 0..(5-(estrellaMitad+estrellasLlenas)).toInt()-1) {
            estrellas[(estrellaMitad+estrellasLlenas).toInt()+i] = drawableVaciaStar
        }







        return estrellas
    }

}