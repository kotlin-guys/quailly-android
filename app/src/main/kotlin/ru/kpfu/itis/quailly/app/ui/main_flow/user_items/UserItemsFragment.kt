package ru.kpfu.itis.quailly.app.ui.main_flow.user_items

import android.os.Bundle
import androidx.fragment.app.viewModels
import ru.kpfu.itis.quailly.R
import ru.kpfu.itis.quailly.app.ui.base.BaseFragment
import ru.kpfu.itis.quailly.app.ui.main_flow.getMainFlowSubcomponent
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelFactory
import ru.kpfu.itis.quailly.databinding.FragmentUserItemsBinding
import javax.inject.Inject

class UserItemsFragment : BaseFragment<FragmentUserItemsBinding, UserItemsViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override val viewModel: UserItemsViewModel by viewModels { viewModelFactory }
    override fun getLayoutResId(): Int = R.layout.fragment_user_items

    override fun onCreate(savedInstanceState: Bundle?) {
        getMainFlowSubcomponent().userItemsSubcomponent()
            .build()
            .inject(this)

        super.onCreate(savedInstanceState)
    }
}