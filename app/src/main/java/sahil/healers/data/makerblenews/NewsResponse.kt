package sahil.healers.data.makerblenews
data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ApiArticle>
)
