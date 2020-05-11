package ru.kpfu.itis.quailly.app.ui.main_flow.profile

import android.os.Bundle
import androidx.fragment.app.viewModels
import ru.kpfu.itis.quailly.R
import ru.kpfu.itis.quailly.app.ui.base.BaseFragment
import ru.kpfu.itis.quailly.app.ui.main_flow.getMainFlowSubcomponent
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelFactory
import ru.kpfu.itis.quailly.databinding.FragmentProfileBinding
import javax.inject.Inject

class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override val viewModel: ProfileViewModel by viewModels { viewModelFactory }
    override fun getLayoutResId(): Int = R.layout.fragment_profile

    override fun onCreate(savedInstanceState: Bundle?) {
        getMainFlowSubcomponent().profileSubcomponent()
            .build()
            .inject(this)

        super.onCreate(savedInstanceState)
    }
}