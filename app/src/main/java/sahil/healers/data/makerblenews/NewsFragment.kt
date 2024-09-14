package sahil.healers.data.makerblenews
import NewsAdapter
import NewsViewModel
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import sahil.healers.data.makerblenews.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: NewsViewModel
    private lateinit var adapter:   NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bookmarkDao = BookmarkDatabase.getDatabase(requireContext()).bookmarkDao()
        val factory = NewsViewModelFactory(bookmarkDao)

        viewModel = ViewModelProvider(this, factory)[NewsViewModel::class.java]

        adapter = NewsAdapter(
            onBookmarkClick = { apiArticle ->
                val article = Article(
                    sourceName = apiArticle.source.name,
                    author = apiArticle.author,
                    title = apiArticle.title,
                    description = apiArticle.description,
                    url = apiArticle.url,
                    urlToImage = apiArticle.urlToImage,
                    publishedAt = apiArticle.publishedAt,
                    content = apiArticle.content
                )
                Toast.makeText(context, "Bookmark Added", Toast.LENGTH_SHORT).show()
                viewModel.saveArticle(article)
            },
            onItemClick = { apiArticle ->
                val article = Article(
                    sourceName = apiArticle.source.name,
                    author = apiArticle.author,
                    title = apiArticle.title,
                    description = apiArticle.description,
                    url = apiArticle.url,
                    urlToImage = apiArticle.urlToImage,
                    publishedAt = apiArticle.publishedAt,
                    content = apiArticle.content
                )
                val intent = Intent(requireContext(), DetailsActivity::class.java).apply {
                    putExtra("article", article)  // Pass ApiArticle to the detail activity
                }
                startActivity(intent)
            }
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        viewModel.newsList.observe(viewLifecycleOwner) { news ->
            if (news != null) {
                adapter.submitList(news)
            }
        }

        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                ViewState.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                    binding.textViewMessage.visibility = View.GONE
                }
                ViewState.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    binding.recyclerView.visibility = View.VISIBLE
                    binding.textViewMessage.visibility = View.GONE
                }
                ViewState.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    binding.recyclerView.visibility = View.GONE
                    binding.textViewMessage.visibility = View.VISIBLE
                    binding.textViewMessage.text = "Error loading news."
                }
                ViewState.EMPTY -> {
                    binding.progressBar.visibility = View.GONE
                    binding.recyclerView.visibility = View.GONE
                    binding.textViewMessage.visibility = View.VISIBLE
                    binding.textViewMessage.text = "No news available."
                }
            }
        }

        viewModel.fetchNews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
