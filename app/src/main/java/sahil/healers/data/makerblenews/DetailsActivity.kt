package sahil.healers.data.makerblenews

import NewsViewModel
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import sahil.healers.data.makerblenews.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bookmarkDao = BookmarkDatabase.getDatabase(applicationContext).bookmarkDao()
        val factory = NewsViewModelFactory(bookmarkDao)
        viewModel = ViewModelProvider(this, factory)[NewsViewModel::class.java]
        val article = intent.getParcelableExtra<Article>("article")
        article?.let {
            bindArticleDetails(it)
        }

        binding.buttonBookmark.setOnClickListener {
            article?.let {
                val articleToSave = Article(
                    sourceName = it.sourceName,
                    author = it.author,
                    title = it.title,
                    description = it.description,
                    url = it.url,
                    urlToImage = it.urlToImage,
                    publishedAt = it.publishedAt,
                    content = it.content
                )
                viewModel.saveArticle(articleToSave)
                Toast.makeText(application, "Bookmark Added", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun bindArticleDetails(article: Article) {
        binding.textViewTitle.text = article.title
        binding.textViewContent.text = article.content
        binding.pub.text=article.publishedAt
        binding.auther.text=article.author
        binding.source.text=article.sourceName
        binding.viewfull.setOnClickListener {
            val uri= Uri.parse(article.url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        Glide.with(this).load(article.urlToImage).into(binding.imageViewThumbnail)

    }
}
