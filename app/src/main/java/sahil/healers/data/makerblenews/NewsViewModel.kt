import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sahil.healers.data.makerblenews.ApiArticle
import sahil.healers.data.makerblenews.Article
import sahil.healers.data.makerblenews.BookmarkDao
import sahil.healers.data.makerblenews.NewsApi
import sahil.healers.data.makerblenews.ViewState


class NewsViewModel(private val articleDao: BookmarkDao) : ViewModel() {

    private val _state = MutableLiveData<Int>()
    val state: LiveData<Int> get() = _state

    private val _newsList = MutableLiveData<List<ApiArticle>>()
    val newsList: LiveData<List<ApiArticle>> get() = _newsList

    init {
        fetchNews()
    }

    fun fetchNews() {
        _state.value = ViewState.LOADING

        viewModelScope.launch {
            try {
                val response = NewsApi.retrofitService.getTopHeadlines()
                if (response.isSuccessful) {
                    val apiarticles = response.body()?.articles
                    if (apiarticles.isNullOrEmpty()) {
                        _state.value = ViewState.EMPTY
                    } else {
                        _newsList.value = apiarticles!!
                        _state.value = ViewState.SUCCESS
                    }
                } else {
                    _state.value = ViewState.ERROR
                }
            } catch (e: Exception) {
                _state.value = ViewState.ERROR
            }
        }
    }

    fun saveArticle(article: Article) {
        viewModelScope.launch {
            articleDao.insert(article)
        }
    }
}
