import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import sahil.healers.data.makerblenews.ApiArticle
import sahil.healers.data.makerblenews.Article
import sahil.healers.data.makerblenews.databinding.ItemNewsBinding

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    private val articles = mutableListOf<ApiArticle>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    fun submitList(newArticles: List<ApiArticle>) {
        articles.clear()
        articles.addAll(newArticles)
        notifyDataSetChanged()
    }

    class ArticleViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(article: ApiArticle) {
            binding.textViewTitle.text = article.title
            binding.textViewDescription.text = article.description
             Glide.with(binding.imageViewThumbnail.context).load(article.urlToImage).into(binding.imageViewThumbnail)
        }
    }
}
