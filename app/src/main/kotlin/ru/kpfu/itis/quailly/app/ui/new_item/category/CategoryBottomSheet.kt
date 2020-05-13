package ru.kpfu.itis.quailly.app.ui.new_item.category

import android.os.Bundle
import androidx.fragment.app.viewModels
import ru.kpfu.itis.quailly.R
import ru.kpfu.itis.quailly.app.ui.base.BaseBottomSheet
import ru.kpfu.itis.quailly.app.ui.getMainActivitySubcomponent
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelFactory
import ru.kpfu.itis.quailly.databinding.BottomSheetCategoriesBinding
import javax.inject.Inject

class CategoryBottomSheet :
    BaseBottomSheet<BottomSheetCategoriesBinding, CategoryViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override val viewModel: CategoryViewModel by viewModels { viewModelFactory }
    override fun getLayoutResId(): Int = R.layout.bottom_sheet_categories

    override fun onCreate(savedInstanceState: Bundle?) {
        getMainActivitySubcomponent().categorySubcomponentBuilder()
            .build()
            .inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun init() {
        viewModel.reqCode = CategoryBottomSheetArgs.fromBundle(requireArguments()).reqCode
    }
}