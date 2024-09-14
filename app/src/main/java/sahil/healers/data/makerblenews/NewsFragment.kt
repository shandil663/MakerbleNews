package sahil.healers.data.makerblenews

import NewsAdapter
import NewsViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import sahil.healers.data.makerblenews.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: NewsViewModel
    private lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ViewModel initialization
        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]

        // RecyclerView and Adapter setup
        adapter = NewsAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        // Observe news list outside state changes to avoid multiple observers
        viewModel.newsList.observe(viewLifecycleOwner) { news ->
            if (news != null) {
                adapter.submitList(news)
            }
        }

        // Observe the state of the ViewModel
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
                    binding.textViewMessage.text = "Error loading news."+ViewState.ERROR.toString()
                }

                ViewState.EMPTY -> {
                    binding.progressBar.visibility = View.GONE
                    binding.recyclerView.visibility = View.GONE
                    binding.textViewMessage.visibility = View.VISIBLE
                    binding.textViewMessage.text = "No news available."
                }
            }
        }

        // Fetch news when the fragment is created
        viewModel.fetchNews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
