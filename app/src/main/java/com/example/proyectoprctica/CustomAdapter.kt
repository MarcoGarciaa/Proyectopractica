package com.example.proyectoprctica

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import android.content.Intent

class CustomAdapter(private val context: Context, private val images: List<Int>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        //INFLAMOS LO QUE SERA EL ELEMENTO DEL RECYCLEVIEW
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //ASIGNACION DE LOS RECURSOS DE LA LISTA
        val currentImage = images[position]
        holder.imageView1.setImageResource(currentImage)
        holder.imageView2.setImageResource(currentImage)
        holder.imageView3.setImageResource(currentImage)

        val slideInBottom = AnimationUtils.loadAnimation(context, R.anim.slide_in_bottom)
        val slideOutTop = AnimationUtils.loadAnimation(context, R.anim.slide_out_top)

        val animationDuration = 2000L // Duración de la animación en milisegundos

        // Función para ejecutar las animaciones
        fun runAnimation() {
            for (i in 1..5) {
                holder.imageView1.startAnimation(slideInBottom)
                holder.imageView2.startAnimation(slideInBottom)
                holder.imageView3.startAnimation(slideInBottom)

                slideInBottom.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation?) {}

                    override fun onAnimationEnd(animation: Animation?) {
                        holder.imageView1.startAnimation(slideOutTop)
                        holder.imageView2.startAnimation(slideOutTop)
                        holder.imageView3.startAnimation(slideOutTop)
                    }

                    override fun onAnimationRepeat(animation: Animation?) {}
                })
            }



        }

        // Ejecutar la animación inicial y luego repetirla continuamente
        runAnimation()
        Log.d("TAG", "Error?")

    }


    override fun getItemCount(): Int {
        return images.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //var linearLayout: LinearLayout = itemView.findViewById(R.id.Linnear01)
        var imageView1: ImageView = itemView.findViewById(R.id.imageView)
        var imageView2: ImageView = itemView.findViewById(R.id.imageView2)
        var imageView3: ImageView = itemView.findViewById(R.id.imageView3)


    }

}

class CustomAdapter02(private val context: Context, private val lista: List<Pair<String, List<List<Any>>>>) :
    RecyclerView.Adapter<CustomAdapter02.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.texto.text = lista[position].first // Primer elemento del par, que es un String
        holder.recyclerView.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)

        // Configuración del adaptador horizontal
        val adapter = HorizontalAdapter(context, lista[position].second.flatten()) // Pasar el contexto
        holder.recyclerView.adapter = adapter
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recyclerView: RecyclerView = itemView.findViewById(R.id.horizontalScrollView)
        var texto: TextView = itemView.findViewById(R.id.textViewTitulo)
    }
}


class HorizontalAdapter(private val context: Context, private val itemList: List<Any>) : RecyclerView.Adapter<HorizontalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflamos el diseño del elemento del RecyclerView horizontal
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item3, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        if (item is Int) {
            holder.imageView1.setImageResource(item)
        }
        holder.imageView1.setOnClickListener {
            val intent = Intent(context, InfoMovie::class.java).apply {
                // Acceder a los elementos en itemList
                val segundoElemento = itemList[position] as? Int ?: 0
                val tercerElemento = itemList[position + 1] as? String ?: ""
                val cuartoElemento = itemList[position + 2] as? String ?: ""
                val quintoElemento = itemList[position + 3] as? String ?: ""

                // Pasar datos de la película a la Activity de detalles
                putExtra("MOVIE_ID", segundoElemento)
                putExtra("MOVIE_TITLE", tercerElemento)
                putExtra("MOVIE_POSTER", cuartoElemento)
                putExtra("MOVIE_RATE", quintoElemento)

                // Agrega cualquier otro dato que necesites
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView1: ImageView = itemView.findViewById(R.id.posters)
    }
}
