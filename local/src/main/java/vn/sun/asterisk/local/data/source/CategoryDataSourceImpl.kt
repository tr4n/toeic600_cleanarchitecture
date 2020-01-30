package vn.sun.asterisk.local.data.source

import vn.sun.asterisk.data.data.source.CategoryDataSource
import vn.sun.asterisk.data.entity.CategoryEntity
import vn.sun.asterisk.local.db.AppDatabase
import vn.sun.asterisk.local.entity.LocalCategory

class CategoryDataSourceImpl(
    private val database: AppDatabase
) : CategoryDataSource {

    override suspend fun getCategories(): List<CategoryEntity> =
        database.topicDao().getCategoryNames().map { name ->

            val subTopics = database.topicDao().getTopics().filter { it.category == name }
            LocalCategory(
                name = name,
                color = subTopics.first().color ?: "",
                topics = subTopics
            ).map()
        }
}
