package com.example.proyectoprctica

class recursos {
}
object GlobalVariables {
    var id: String = ""
}


// Clase auxiliar para almacenar datos estáticos
object DataProvider {

    val dataLists: List<Pair<String, List<List<Any>>>> = listOf(
        Pair("Accion", listOf(
            listOf(R.drawable.laura__1944_film_poster_, "texto1", "texto2", "texto3"),
            listOf(R.drawable.centautosdeldesierto, "texto4", "texto5", "texto6")
        )),
        Pair("Comedia", listOf(
            listOf(R.drawable.centautosdeldesierto, "texto7", "texto8", "texto9"),
            listOf(R.drawable.onceuponatime, "texto10", "texto11", "texto12"),
            listOf(R.drawable.tesis, "texto10", "texto11", "texto12")
        )),
        Pair("Terror", listOf(
            listOf(R.drawable.centautosdeldesierto, "texto7", "texto8", "texto9"),
            listOf(R.drawable.centautosdeldesierto, "texto10", "texto11", "texto12")
        )),
        Pair("Cine Negro", listOf(
            listOf(R.drawable.centautosdeldesierto, "texto7", "texto8", "texto9"),
            listOf(R.drawable.centautosdeldesierto, "texto10", "texto11", "texto12")
        ))
    )


}
