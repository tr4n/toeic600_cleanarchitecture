package vn.sun.asterisk.toeic600.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import org.koin.core.KoinComponent
import vn.sun.asterisk.presentation.viewmodel.BaseViewModel

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity(), KoinComponent {

    @get:LayoutRes
    protected abstract val layoutResource: Int

    protected abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutResource)
        hideActionBar()
        initComponents()
        observeData()
    }

    private fun hideActionBar() = supportActionBar?.hide()

    protected abstract fun initComponents()

    protected abstract fun observeData()

    protected fun replaceFragment(id: Int, fragment: Fragment, addToBackStack: Boolean) =
        supportFragmentManager.beginTransaction().replace(id, fragment).apply {
            if (addToBackStack) addToBackStack(null)
        }.commit()
}
