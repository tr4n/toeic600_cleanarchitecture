package vn.sun.asterisk.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import vn.sun.asterisk.data.entity.MappableData
import vn.sun.asterisk.data.entity.TopicEntity

@Entity(tableName = LocalTopic.TABLE_NAME)
data class LocalTopic(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = FIELD_ID) var id: Int = 0,
    @ColumnInfo(name = FIELD_NAME) var name: String = "",
    @ColumnInfo(name = FIELD_IMAGE_URL) var imageUrl: String = "",
    @ColumnInfo(name = FIELD_CATEGORY) var category: String = "",
    @ColumnInfo(name = FIELD_COLOR) var color: String? = null,
    @ColumnInfo(name = FIELD_LAST_TIME) var lastTime: String? = null,
    @ColumnInfo(name = FIELD_TOTAL) var total: Int = 12,
    @ColumnInfo(name = FIELD_MASTER) var master: Int = 0,
    @ColumnInfo(name = FIELD_NEW_WORD) var newWord: Int = 0,
    @ColumnInfo(name = FIELD_REMIND) var remind: Int = 0
) : MappableData<TopicEntity> {

    override fun map() =
        TopicEntity(id, name, imageUrl, category, color, lastTime, total, master, newWord, remind)

    companion object {
        const val IS_REMINDED = 1
        const val IS_NOT_REMINDED = 0
        const val TABLE_NAME = "tbl_topic"
        const val FIELD_ID = "id"
        const val FIELD_NAME = "name"
        const val FIELD_IMAGE_URL = "image_url"
        const val FIELD_CATEGORY = "category"
        const val FIELD_COLOR = "color"
        const val FIELD_LAST_TIME = "last_time"
        const val FIELD_TOTAL = "total"
        const val FIELD_MASTER = "master"
        const val FIELD_NEW_WORD = "new_word"
        const val FIELD_REMIND = "remind"
    }
}
