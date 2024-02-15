package com.example.proyectoprctica

class recursos {
}
class idUsuario private constructor() {
    // Variable global
    var  idUsuario:  String? = null

    companion object {
        // Referencia a la única instancia de la clase
        @Volatile
        private var instance: idUsuario? = null

        // Función para obtener la instancia de la clase
        fun getInstance(): idUsuario {
            return instance ?: synchronized(this) { instance ?: idUsuario().also { instance = it }
            }
        }
    }

    // Función para inicializar la variable global del personaje
    fun initUsuario(id: String?) {
        idUsuario = id
    }

}

