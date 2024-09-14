package sahil.healers.data.makerblenews

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BookmarkDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(bookmark: Article)

    @Query("SELECT * FROM article")
    fun getAllBookmarks(): LiveData<List<Article>>

    @Delete
    suspend fun delete(bookmark: Article)
}
