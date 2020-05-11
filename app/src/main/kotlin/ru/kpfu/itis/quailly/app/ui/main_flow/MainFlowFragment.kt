package ru.kpfu.itis.quailly.app.ui.main_flow

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import ru.kpfu.itis.quailly.app.ui.main_flow.di.MainFlowSubcomponent
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_main_flow.*
import ru.kpfu.itis.quailly.R
import ru.kpfu.itis.quailly.app.ui.base.BaseFragment
import ru.kpfu.itis.quailly.app.ui.getMainActivitySubcomponent
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelFactory
import ru.kpfu.itis.quailly.app.ui.utils.ext.setupWithNavController
import ru.kpfu.itis.quailly.databinding.FragmentMainFlowBinding
import javax.inject.Inject

class MainFlowFragment : BaseFragment<FragmentMainFlowBinding, MainFlowViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override val viewModel: MainFlowViewModel by viewModels { viewModelFactory }
    override fun getLayoutResId(): Int = R.layout.fragment_main_flow

    lateinit var mainFlowSubcomponent: MainFlowSubcomponent

    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        mainFlowSubcomponent = getMainActivitySubcomponent().mainFlowSubcomponentBuilder()
            .build()
        mainFlowSubcomponent.inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun init() {
        val navController = requireActivity().findNavController(R.id.nav_host_main_flow_fragment)
        bottomNav.setupWithNavController(navController)

        val bottomNavigationView =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottomNav)

        val navGraphIds = listOf(
            R.navigation.nav_graph_all_items,
            R.navigation.nav_graph_user_items,
            R.navigation.nav_graph_profile
        )

        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = childFragmentManager,
            containerId = R.id.nav_host_main_flow_fragment,
            intent = requireActivity().intent
        )

        currentNavController = controller
    }
}

fun Fragment.getMainFlowSubcomponent() =
    (parentFragment?.parentFragment as MainFlowFragment).mainFlowSubcomponent
