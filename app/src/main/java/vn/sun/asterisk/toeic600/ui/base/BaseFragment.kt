package vn.sun.asterisk.toeic600.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import org.koin.core.KoinComponent
import vn.sun.asterisk.presentation.viewmodel.BaseViewModel

abstract class BaseFragment<VM : BaseViewModel> : Fragment(), KoinComponent {

    @get:LayoutRes
    protected abstract val layoutResource: Int
    protected abstract val viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(layoutResource, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initComponents()
        initData()
        observeData()
    }

    protected abstract fun initComponents()

    protected open fun initData() {
        viewModel.create()
    }

    protected open fun observeData() {
        viewModel.messageToast.observe(viewLifecycleOwner, Observer(::toast))
    }

    protected fun replaceFragment(id: Int, fragment: Fragment, addToBackStack: Boolean) {
        activity?.supportFragmentManager?.beginTransaction()?.replace(id, fragment)?.apply {
            if (addToBackStack) addToBackStack(null)
        }?.commit()
    }

    protected fun addFragment(id: Int, fragment: Fragment, addToBackStack: Boolean) =
        activity?.supportFragmentManager?.beginTransaction()?.add(id, fragment)?.apply {
            if (addToBackStack) addToBackStack(null)
        }?.commit()

    private fun toast(message: String) {
        context?.let {
            Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
        }
    }
}
