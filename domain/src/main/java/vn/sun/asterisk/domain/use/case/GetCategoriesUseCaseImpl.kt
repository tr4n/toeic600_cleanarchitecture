package vn.sun.asterisk.domain.use.case

import vn.sun.asterisk.domain.model.Category
import vn.sun.asterisk.domain.repository.CategoryRepository

class GetCategoriesUseCaseImpl(
    private val repository: CategoryRepository
) : UseCaseNoParam<List<Category>> {

    override suspend fun execute(): List<Category> = repository.getCategories()
}
