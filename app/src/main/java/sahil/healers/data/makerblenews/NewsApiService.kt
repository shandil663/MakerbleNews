package sahil.healers.data.makerblenews

import retrofit2.Response
import retrofit2.http.GET

interface NewsApiService {
    @GET("v2/top-headlines?country=us&apiKey=ca4af58758784352a155b4c1c1482831")
    suspend fun getTopHeadlines(): Response<NewsResponse>
}
