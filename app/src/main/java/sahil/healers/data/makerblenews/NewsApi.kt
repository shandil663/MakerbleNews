package sahil.healers.data.makerblenews

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsApi {
    private const val BASE_URL = "https://newsapi.org/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val retrofitService: NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }
}
