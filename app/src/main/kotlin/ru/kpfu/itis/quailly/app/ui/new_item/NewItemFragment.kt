package ru.kpfu.itis.quailly.app.ui.new_item

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.viewModels
import ru.kpfu.itis.quailly.app.ui.base.BaseFragment
import ru.kpfu.itis.quailly.R
import ru.kpfu.itis.quailly.app.ui.getMainActivitySubcomponent
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelFactory
import ru.kpfu.itis.quailly.databinding.FragmentNewItemBinding
import javax.inject.Inject

class NewItemFragment : BaseFragment<FragmentNewItemBinding, NewItemViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override val viewModel: NewItemViewModel by viewModels { viewModelFactory }
    override fun getLayoutResId(): Int = R.layout.fragment_new_item

    override fun onCreate(savedInstanceState: Bundle?) {
        getMainActivitySubcomponent().newItemSubcomponentBuilder()
            .build()
            .inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun init() {
        observeNavigationResult<Uri>(viewModel.reqCodePhoto.toString())
    }
}