package vn.sun.asterisk.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import vn.sun.asterisk.local.DatabaseConfig

@Entity(
    tableName = LocalWord.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = LocalTopic::class,
            parentColumns = [LocalTopic.FIELD_ID],
            childColumns = [LocalWord.FIELD_TOPIC_ID]
        )
    ]
)
data class LocalWord(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = FIELD_ID, index = true) val id: Int,
    @ColumnInfo(name = FIELD_ORIGIN) val origin: String,
    @ColumnInfo(name = FIELD_EXPLANATION) val explanation: String,
    @ColumnInfo(name = FIELD_TYPE) val type: String,
    @ColumnInfo(name = FIELD_PRONUNCIATION) val pronunciation: String? = null,
    @ColumnInfo(name = FIELD_IMAGE_URL) val imageUrl: String,
    @ColumnInfo(name = FIELD_EXAMPLE) val example: String,
    @ColumnInfo(name = FIELD_EXAMPLE_TRANSLATION) val exampleTranslate: String? = null,
    @ColumnInfo(name = FIELD_TOPIC_ID) val topicId: Int,
    @ColumnInfo(name = FIELD_LEVEL) var level: Int = 0
) {

    val soundUrl get() = String.format(DatabaseConfig.SOUND_URL_FORMAT, origin.replace(' ', '_'))

    companion object {
        const val TABLE_NAME = "tbl_word"
        const val FIELD_ID = "id"
        const val FIELD_ORIGIN = "origin"
        const val FIELD_EXPLANATION = "explanation"
        const val FIELD_TYPE = "type"
        const val FIELD_PRONUNCIATION = "pronunciation"
        const val FIELD_IMAGE_URL = "image_url"
        const val FIELD_EXAMPLE = "example"
        const val FIELD_EXAMPLE_TRANSLATION = "example_translation"
        const val FIELD_TOPIC_ID = "topic_id"
        const val FIELD_LEVEL = "level"
    }
}
