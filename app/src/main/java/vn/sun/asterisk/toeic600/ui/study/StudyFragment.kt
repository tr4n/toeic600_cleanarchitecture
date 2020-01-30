package vn.sun.asterisk.toeic600.ui.study

import org.koin.android.viewmodel.ext.android.viewModel
import vn.sun.asterisk.presentation.viewmodel.StudyViewModel
import vn.sun.asterisk.toeic600.R
import vn.sun.asterisk.toeic600.ui.base.BaseFragment

class StudyFragment : BaseFragment<StudyViewModel>() {

    override val layoutResource get() = R.layout.study_fragment

    override val viewModel by viewModel<StudyViewModel>()

    override fun initComponents() {
    }
}
