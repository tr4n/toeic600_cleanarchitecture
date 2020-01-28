package vn.sun.asterisk.toeic600.ui.main

import org.koin.android.viewmodel.ext.android.viewModel
import vn.sun.asterisk.presentation.viewmodel.MainViewModel
import vn.sun.asterisk.toeic600.R
import vn.sun.asterisk.toeic600.ui.base.BaseActivity
import vn.sun.asterisk.toeic600.ui.category.CategoryFragment

class MainActivity : BaseActivity<MainViewModel>() {

    override val layoutResource: Int get() = R.layout.activity_main

    override val viewModel by viewModel<MainViewModel>()

    override fun initComponents() {
        replaceFragment(R.id.frameContent, CategoryFragment.newInstance(), true)
    }

    override fun observeData() {
    }
}
