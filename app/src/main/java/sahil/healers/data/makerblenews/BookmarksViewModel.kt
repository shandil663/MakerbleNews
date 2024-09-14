package sahil.healers.data.makerblenews

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class BookmarksViewModel(application: Application) : AndroidViewModel(application) {

    private val bookmarkDao = BookmarkDatabase.getDatabase(application).bookmarkDao()
    val allBookmarks: LiveData<List<Article>> = bookmarkDao.getAllBookmarks()
}
