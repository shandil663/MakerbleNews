package sahil.healers.data.makerblenews
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromSource(source: Source?): String? {
        return source?.let { gson.toJson(it) }
    }

    @TypeConverter
    fun toSource(sourceString: String?): Source? {
        return sourceString?.let {
            val type = object : TypeToken<Source>() {}.type
            gson.fromJson(it, type)
        }
    }
}
