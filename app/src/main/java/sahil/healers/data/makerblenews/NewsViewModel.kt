import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sahil.healers.data.makerblenews.ApiArticle
import sahil.healers.data.makerblenews.NewsApi
import sahil.healers.data.makerblenews.ViewState

class NewsViewModel : ViewModel() {

    // State to indicate the current state (loading, success, error, etc.)
    private val _state = MutableLiveData<Int>()
    val state: LiveData<Int> get() = _state

    // News list that can be observed by the UI
    private val _newsList = MutableLiveData<List<ApiArticle>?>()
    val newsList: LiveData<List<ApiArticle>?> get() = _newsList

    init {
        fetchNews()
    }

    // Function to fetch the news articles from the API
    fun fetchNews() {
        _state.value = ViewState.LOADING // Set loading state

        // Use coroutine scope for background operations
        viewModelScope.launch {
            try {
                // Fetch the data from API
                val response = NewsApi.retrofitService.getTopHeadlines()

                if (response.isSuccessful) {
                    val newsResponse = response.body()
                    val apiArticles = newsResponse?.articles

                    // Check if the articles list is null or empty
                    if (apiArticles.isNullOrEmpty()) {
                        _state.value = ViewState.EMPTY // No data available
                    } else {
                        _newsList.value = apiArticles // Update the LiveData with the articles
                        _state.value = ViewState.SUCCESS // Success
                    }
                } else {
                    _state.value = ViewState.ERROR // Error in response
                }
            } catch (e: Exception) {
                // Catch any exception during the API call and set error state
                _state.value = ViewState.ERROR
                e.printStackTrace() // Optional: log the error for debugging
            }
        }
    }
}
