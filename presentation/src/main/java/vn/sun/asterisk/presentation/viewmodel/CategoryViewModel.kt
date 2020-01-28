package vn.sun.asterisk.presentation.viewmodel

import androidx.lifecycle.liveData
import vn.sun.asterisk.domain.model.Category
import vn.sun.asterisk.domain.use.case.UseCaseNoParam

class CategoryViewModel(
    private val getCategoriesUseCase: UseCaseNoParam<List<Category>>
) : BaseViewModel() {

    val categories = liveData {
        try {
            emit(getCategoriesUseCase.execute())
        } catch (e: Exception) {
            emit(emptyList())
        }
    }
}
