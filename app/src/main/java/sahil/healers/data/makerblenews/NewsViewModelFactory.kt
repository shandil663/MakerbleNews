package sahil.healers.data.makerblenews
import NewsViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NewsViewModelFactory(private val bookmarkDao: BookmarkDao) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            return NewsViewModel(bookmarkDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
