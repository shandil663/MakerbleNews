
package sahil.healers.data.makerblenews
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import sahil.healers.data.makerblenews.Article

@Dao
interface   BookmarkDao {


    @Insert
    suspend fun insert(article: Article)


    @Query("SELECT * FROM article")
    fun getAllBookmarks(): LiveData<List<Article>>


    @Delete
    suspend fun delete(article: Article)
}
