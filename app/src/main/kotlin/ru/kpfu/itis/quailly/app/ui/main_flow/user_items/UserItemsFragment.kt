package ru.kpfu.itis.quailly.app.ui.main_flow.user_items

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.fragment_user_items.*
import ru.kpfu.itis.quailly.R
import ru.kpfu.itis.quailly.app.ui.base.BaseFragment
import ru.kpfu.itis.quailly.app.ui.main_flow.getMainFlowSubcomponent
import ru.kpfu.itis.quailly.app.ui.main_flow.user_items.adapter.MerchandisesAdapter
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelFactory
import ru.kpfu.itis.quailly.databinding.FragmentUserItemsBinding
import javax.inject.Inject

class UserItemsFragment : BaseFragment<FragmentUserItemsBinding, UserItemsViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var adapter: MerchandisesAdapter

    override val viewModel: UserItemsViewModel by viewModels { viewModelFactory }
    override fun getLayoutResId(): Int = R.layout.fragment_user_items

    override fun onCreate(savedInstanceState: Bundle?) {
        getMainFlowSubcomponent().userItemsSubcomponent()
            .build()
            .inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.setupWithNavController(findNavController())
        binding.listMerchandises.adapter = adapter

        viewModel.merchandisesList.observe(viewLifecycleOwner, Observer {
            adapter.items = it
        })
    }
}