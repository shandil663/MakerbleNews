package sahil.healers.data.makerblenews

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import sahil.healers.data.makerblenews.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


//        val binding = ActivityDetailsBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val article = intent.getParcelableExtra<Article>("article")
//
//        binding.textViewTitle.text = article?.title
//        binding.textViewAuthor.text = article?.author
//        binding.textViewPublishedAt.text = article?.publishedAt
//        binding.textViewContent.text = article?.content
//        Glide.with(this).load(article?.urlToImage).into(binding.imageViewThumbnail)
//
//        // Add a button to bookmark this article
//        binding.buttonBookmark.setOnClickListener {
//            // Save to Room database
//        }
    }
}