package ru.kpfu.itis.quailly.app.ui.main_flow.all_items

import android.os.Bundle
import androidx.fragment.app.viewModels
import ru.kpfu.itis.quailly.R
import ru.kpfu.itis.quailly.app.ui.base.BaseFragment
import ru.kpfu.itis.quailly.app.ui.main_flow.getMainFlowSubcomponent
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelFactory
import ru.kpfu.itis.quailly.databinding.FragmentAllItemsBinding
import javax.inject.Inject

class AllItemsFragment : BaseFragment<FragmentAllItemsBinding, AllItemsViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override val viewModel: AllItemsViewModel by viewModels { viewModelFactory }
    override fun getLayoutResId(): Int = R.layout.fragment_all_items

    override fun onCreate(savedInstanceState: Bundle?) {
        getMainFlowSubcomponent().allItemsSubcomponent()
            .build()
            .inject(this)

        super.onCreate(savedInstanceState)
    }
}
