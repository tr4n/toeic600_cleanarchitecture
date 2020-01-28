package vn.sun.asterisk.local.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import vn.sun.asterisk.local.entity.LocalWord

@Dao
interface WordDao {

    @Query("SELECT * FROM ${LocalWord.TABLE_NAME}")
    suspend fun getWords(): List<LocalWord>

    @Query("SELECT * FROM ${LocalWord.TABLE_NAME} WHERE ${LocalWord.FIELD_TOPIC_ID} = :topicId")
    suspend fun getWordsByTopic(topicId: Int): List<LocalWord>

    @Update
    suspend fun updateWord(word: LocalWord)
}
