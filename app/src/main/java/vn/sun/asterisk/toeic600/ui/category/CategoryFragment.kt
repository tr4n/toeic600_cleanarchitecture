package vn.sun.asterisk.toeic600.ui.category


import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_category.*
import org.koin.android.viewmodel.ext.android.viewModel
import vn.sun.asterisk.presentation.viewmodel.CategoryViewModel
import vn.sun.asterisk.toeic600.R
import vn.sun.asterisk.toeic600.ui.base.BaseFragment

class CategoryFragment : BaseFragment<CategoryViewModel>() {

    override val layoutResource: Int get() = R.layout.fragment_category

    override val viewModel by viewModel<CategoryViewModel>()

    private val categoryAdapter = CategoryAdapter { topic ->
        activity?.let {
            val action = CategoryFragmentDirections.actionCategoryFragmentToStudyFragment(topic)
            Navigation.findNavController(it, R.id.navHostFragment).navigate(action)
        }
    }

    override fun initComponents() {
        recyclerCategories.adapter = categoryAdapter
    }

    override fun observeData() = with(viewModel) {
        super.observeData()
        categories.observe(viewLifecycleOwner, Observer(categoryAdapter::submitList))
    }
}
