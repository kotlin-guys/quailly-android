package ru.kpfu.itis.quailly.app.ui.main_flow.all_items

import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.fragment.app.viewModels
import kotlinx.android.synthetic.main.fragment_all_items.*
import ru.kpfu.itis.quailly.R
import ru.kpfu.itis.quailly.app.ui.base.BaseFragment
import ru.kpfu.itis.quailly.app.ui.main_flow.getMainFlowSubcomponent
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelFactory
import ru.kpfu.itis.quailly.databinding.FragmentAllItemsBinding
import ru.kpfu.itis.quailly.domain.model.Direction
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

    override fun init() {

        motionLayout.setTransitionListener(object : TransitionAdapter() {

            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                when (currentId) {
                    R.id.offScreenPass -> {
                        motionLayout.progress = 0f
                        motionLayout.setTransition(R.id.rest, R.id.like)
                        viewModel.swipe(Direction.LEFT)
                    }
                    R.id.offScreenLike -> {
                        motionLayout.progress = 0f
                        motionLayout.setTransition(R.id.rest, R.id.like)
                        viewModel.swipe(Direction.RIGHT)
                    }
                }
            }

        })

        likeButton.setOnClickListener {
            motionLayout.transitionToState(R.id.like)
        }

        passButton.setOnClickListener {
            motionLayout.transitionToState(R.id.pass)
        }
    }
}
