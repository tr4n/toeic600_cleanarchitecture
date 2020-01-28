package vn.sun.asterisk.toeic600.ui.category


import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_category.*
import org.koin.android.viewmodel.ext.android.viewModel
import vn.sun.asterisk.presentation.viewmodel.CategoryViewModel
import vn.sun.asterisk.toeic600.R
import vn.sun.asterisk.toeic600.ui.base.BaseFragment

class CategoryFragment private constructor() : BaseFragment<CategoryViewModel>() {

    override val layoutResource: Int get() = R.layout.fragment_category

    override val viewModel by viewModel<CategoryViewModel>()

    private val categoryAdapter = CategoryAdapter()

    override fun initComponents() {
        recyclerCategories.adapter = categoryAdapter
    }

    override fun observeData() = with(viewModel) {
        super.observeData()
        categories.observe(viewLifecycleOwner, Observer(categoryAdapter::submitList))
    }

    companion object {
        fun newInstance() = CategoryFragment()
    }
}
