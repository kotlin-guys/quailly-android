package ru.kpfu.itis.quailly.app.ui.new_item.desired_categories

import android.os.Bundle
import androidx.fragment.app.viewModels
import ru.kpfu.itis.quailly.R
import ru.kpfu.itis.quailly.app.ui.base.BaseBottomSheet
import ru.kpfu.itis.quailly.app.ui.getMainActivitySubcomponent
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelFactory
import ru.kpfu.itis.quailly.databinding.BottomSheetCategoriesBinding
import ru.kpfu.itis.quailly.databinding.BottomSheetDesiredCategoriesBinding
import javax.inject.Inject

class DesiredCategoriesBottomSheet :
    BaseBottomSheet<BottomSheetDesiredCategoriesBinding, DesiredCategoriesViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override val viewModel: DesiredCategoriesViewModel by viewModels { viewModelFactory }
    override fun getLayoutResId(): Int = R.layout.bottom_sheet_desired_categories

    override fun onCreate(savedInstanceState: Bundle?) {
        getMainActivitySubcomponent().desiredCategoriesSubcomponentBuilder()
            .build()
            .inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun init() {
        viewModel.reqCode = DesiredCategoriesBottomSheetArgs.fromBundle(requireArguments()).reqCode
    }
}