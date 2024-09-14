package sahil.healers.data.makerblenews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import sahil.healers.data.makerblenews.Article
import sahil.healers.data.makerblenews.databinding.ItemBookmarkBinding

class BookmarkAdapter(
    private val onItemClick: (Article) -> Unit,
    private val onBookClick:(Article) -> Unit
) : RecyclerView.Adapter<BookmarkAdapter.ArticleViewHolder>() {

    private val articles = mutableListOf<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemBookmarkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    fun submitList(newArticles: List<Article>) {
        articles.clear()
        articles.addAll(newArticles)
        notifyDataSetChanged()
    }

    inner class ArticleViewHolder(private val binding: ItemBookmarkBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article) {
            binding.textViewTitle.text = article.title
            binding.textViewDescription.text = article.description
            Glide.with(binding.imageViewThumbnail.context).load(article.urlToImage).into(binding.imageViewThumbnail)
binding.textViewSource.text=article.sourceName
            binding.root.setOnClickListener {
                onItemClick(article)
            }
            binding.bookmarkButton.setOnClickListener {
                onBookClick(article)
            }
        }
    }
}
