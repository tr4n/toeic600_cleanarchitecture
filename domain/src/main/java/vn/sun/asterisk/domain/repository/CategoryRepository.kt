package vn.sun.asterisk.domain.repository

import vn.sun.asterisk.domain.model.Category

interface CategoryRepository : Repository {

    suspend fun getCategories(): List<Category>
}
