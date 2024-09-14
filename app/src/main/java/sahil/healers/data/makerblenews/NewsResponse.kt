package sahil.healers.data.makerblenews

// Represents the entire response from the API
data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ApiArticle>  // Use ApiArticle for individual articles
)

// Represents an article received from the API
//data class ApiArticle(
//    val source: Source,
//    val author: String?,
//    val title: String,
//    val description: String?,
//    val url: String,
//    val urlToImage: String?,
//    val publishedAt: String,
//    val content: String?
//)

