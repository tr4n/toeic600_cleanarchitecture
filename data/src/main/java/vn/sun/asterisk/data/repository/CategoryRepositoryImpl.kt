package vn.sun.asterisk.data.repository

import vn.sun.asterisk.data.data.source.CategoryDataSource
import vn.sun.asterisk.data.entity.CategoryEntity
import vn.sun.asterisk.domain.model.Category
import vn.sun.asterisk.domain.repository.CategoryRepository

class CategoryRepositoryImpl(
    private val dataSource: CategoryDataSource
) : CategoryRepository {

    override suspend fun getCategories(): List<Category> =
        dataSource.getCategories().map(CategoryEntity::map)
}
