package vn.sun.asterisk.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import vn.sun.asterisk.local.DatabaseConfig.DATABASE_NAME
import vn.sun.asterisk.local.DatabaseConfig.DATABASE_PATH
import vn.sun.asterisk.local.DatabaseConfig.DATABASE_VERSION
import vn.sun.asterisk.local.entity.LocalTopic
import vn.sun.asterisk.local.entity.LocalWord

@Database(
    entities = [LocalTopic::class, LocalWord::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao
    abstract fun topicDao(): TopicDao

    companion object {
        fun getDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .createFromAsset(DATABASE_PATH)
                .fallbackToDestructiveMigration()
                .build()
    }
}
