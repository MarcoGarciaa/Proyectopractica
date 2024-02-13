package com.example.proyectoprctica

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

class CustomAdapter02(private val context: Context, private val lista: List<List<Int>>) :
    RecyclerView.Adapter<CustomAdapter02.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflamos el diseño del elemento del RecyclerView vertical
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Configuración del RecyclerView horizontal
        holder.recyclerView.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)

        // Configuración del adaptador horizontal
        val adapter = HorizontalAdapter(lista[position])
        holder.recyclerView.adapter = adapter
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var recyclerView: RecyclerView = itemView.findViewById(R.id.horizontalScrollView)
    }
}

class HorizontalAdapter(private val itemList: List<Int>) : RecyclerView.Adapter<HorizontalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflamos el diseño del elemento del RecyclerView horizontal
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item3, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageResId = itemList[position]
        holder.imageView1.setImageResource(imageResId)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView1: ImageView = itemView.findViewById(R.id.imageView)
    }
}
