package vn.sun.asterisk.local.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import vn.sun.asterisk.local.entity.LocalTopic

@Dao
interface TopicDao {
    @Query("SELECT * FROM ${LocalTopic.TABLE_NAME}")
    suspend fun getTopics(): List<LocalTopic>

    @Query("SELECT DISTINCT category FROM ${LocalTopic.TABLE_NAME}")
    suspend fun getCategoryNames(): List<String>

    @Update
    suspend fun updateTopic(topic: LocalTopic)
}
