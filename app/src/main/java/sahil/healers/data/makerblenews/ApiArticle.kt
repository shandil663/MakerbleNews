package sahil.healers.data.makerblenews



import kotlinx.parcelize.Parcelize


data class ApiArticle(
    val source: Source,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String?
)


data class Source(
    val id: String?,  // Optional
    val name: String
)
