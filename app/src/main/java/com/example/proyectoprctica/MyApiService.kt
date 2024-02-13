import android.content.ContentValues
import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException



private val client = OkHttpClient()

fun fetchDataFromApi() {
        val request = Request.Builder()
            .url("https://api.themoviedb.org/3/configuration")
            .get()
            .addHeader("accept", "application/json")
            .addHeader(
                "Authorization",
                "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyMDQ4NTc4MTg1MDY4YWE5M2E0MmM2ZGU4NWIxNjYxMSIsInN1YiI6IjY1Y2JjMTQ4OGMwYTQ4MDE3Y2I4NjJlYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.LalFwMUWPPMHTJEOAmIlN3VWa-TDbXKCD36Li49kB04"
            )
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                // Manejar errores de conexión aquí
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                val responseData = response.body?.string()
                // Procesar la respuesta aquí
                println(responseData)
            }
        })
    }

fun fetchMovieDetails(movieId: Int) {
        val url = "https://api.themoviedb.org/3/movie/$movieId?api_key=2048578185068aa93a42c6de85b16611"
        val request = Request.Builder()
            .url(url)
            .get()
            .addHeader("accept", "application/json")
            .addHeader(
                "Authorization",
                "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyMDQ4NTc4MTg1MDY4YWE5M2E0MmM2ZGU4NWIxNjYxMSIsInN1YiI6IjY1Y2JjMTQ4OGMwYTQ4MDE3Y2I4NjJlYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.LalFwMUWPPMHTJEOAmIlN3VWa-TDbXKCD36Li49kB04"
            )
            .build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                // Manejar errores de conexión aquí
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                val responseData = response.body?.string()
                // Procesar la respuesta aquí
                responseData?.let {
                    val jsonResponse = JSONObject(it)
                    val images = jsonResponse.getJSONObject("images")

                    // Obtener los tamaños de las imágenes disponibles
                    val backdropSizes = images.getJSONArray("backdrop_sizes")
                    val logoSizes = images.getJSONArray("logo_sizes")
                    val posterSizes = images.getJSONArray("poster_sizes")
                    val profileSizes = images.getJSONArray("profile_sizes")
                    val stillSizes = images.getJSONArray("still_sizes")

                    // Obtener los IDs de las películas para cada tipo
                    val changeKeys = jsonResponse.getJSONArray("change_keys")

                    // Imprimir los tamaños de imágenes disponibles
                    println("Backdrop Sizes: $backdropSizes")
                    println("Logo Sizes: $logoSizes")
                    println("Poster Sizes: $posterSizes")
                    println("Profile Sizes: $profileSizes")
                    println("Still Sizes: $stillSizes")

                    // Imprimir los IDs de las películas para cada tipo
                    println("Movie IDs for each type:")
                    for (i in 0 until changeKeys.length()) {
                        val type = changeKeys.getString(i)
                        println("$type: $movieId")
                    }
                }
            }
        })
    }

    // Ejemplo de uso de la función





