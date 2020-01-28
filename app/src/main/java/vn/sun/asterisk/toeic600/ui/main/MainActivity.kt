package vn.sun.asterisk.toeic600.ui.main

import android.view.View
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_navigation_menu.*
import org.koin.android.viewmodel.ext.android.viewModel
import vn.sun.asterisk.presentation.viewmodel.MainViewModel
import vn.sun.asterisk.toeic600.R
import vn.sun.asterisk.toeic600.ui.base.BaseActivity

class MainActivity : BaseActivity<MainViewModel>(), View.OnClickListener {

    override val layoutResource: Int get() = R.layout.activity_main

    override val viewModel by viewModel<MainViewModel>()

    override fun initComponents() {
        textTitle.setOnClickListener(this)
        textVocabulary.setOnClickListener(this)
    }

    override fun observeData() {
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.textTitle -> drawerLayout.openDrawer(GravityCompat.START)
            R.id.textVocabulary -> openTab(
                resId = R.id.categoryFragment,
                title = getString(R.string.title_categories)
            )
        }
    }

    private fun openTab( resId: Int, title: String) {
        drawerLayout.closeDrawer(GravityCompat.START)
        textTitle.text = title
        Navigation.findNavController(this, R.id.navHostFragment).navigate(resId)
    }
}
