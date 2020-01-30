package vn.sun.asterisk.data.data.source

import vn.sun.asterisk.data.entity.CategoryEntity

interface CategoryDataSource : DataSource {

    suspend fun getCategories(): List<CategoryEntity>
}
