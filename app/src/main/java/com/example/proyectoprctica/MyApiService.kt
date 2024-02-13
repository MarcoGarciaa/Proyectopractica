import okhttp3.*
import java.io.IOException

class ApiClient {

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
        val url = "https://api.themoviedb.org/3/movie/$movieId?api_key=YOUR_API_KEY"
        val request = Request.Builder()
            .url(url)
            .get()
            .addHeader("accept", "application/json")
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


}
