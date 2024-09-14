package sahil.healers.data.makerblenews

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "article")
data class Article(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
//    val source: Source, // Source of the article
    val author: String?, // Author of the article
    val title: String, // Title of the article
    val description: String?, // Description of the article
    val url:String,
    val urlToImage: String?, // URL of the article image
    val publishedAt: String, // Publication date
    val content: String? // Content of the article
) : Parcelable

//@Parcelize
//data class Source(
//    val id: String?, // Optional source ID
//    val name: String // Name of the source
//) : Parcelable
