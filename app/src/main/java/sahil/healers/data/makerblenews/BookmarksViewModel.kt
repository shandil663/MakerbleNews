package sahil.healers.data.makerblenews

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BookmarksViewModel(application: Application) : AndroidViewModel(application) {

    private val bookmarkDao = BookmarkDatabase.getDatabase(application).bookmarkDao()

    val allBookmarks: LiveData<List<Article>> = bookmarkDao.getAllBookmarks()

    fun deleteArticle(article: Article) {
        viewModelScope.launch {
            bookmarkDao.delete(article)
        }}
}
