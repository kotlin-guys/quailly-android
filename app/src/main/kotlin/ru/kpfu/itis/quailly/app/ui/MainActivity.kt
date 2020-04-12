package ru.kpfu.itis.quailly.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import ru.kpfu.itis.quailly.R
import ru.kpfu.itis.quailly.app.getAppComponent
import ru.kpfu.itis.quailly.app.ui.di.MainSubcomponent
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var mainSubcomponent: MainSubcomponent

    private val mainViewModel: MainViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        mainSubcomponent = getAppComponent().mainSubcomponentBuilder()
            .build()
        mainSubcomponent.inject(this)

        setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)

        observeNavigation()
    }

    private fun observeNavigation() {
        findNavController(R.id.nav_host_fragment_main).setGraph(R.navigation.nav_graph_auth)

        //TODO:
//        mainViewModel.isAuthed.observe(this) {
//            when (it) {
//                AuthState.NOT_AUTHED -> findNavController(R.id.nav_host_fragment_main).setGraph(R.navigation.nav_graph_authed)
//                AuthState.FULL_AUTHED -> findNavController(R.id.nav_host_fragment_main).setGraph(R.navigation.nav_graph_authed)
//            }
//        }
    }
}

fun Fragment.getMainActivity(): MainActivity = activity as MainActivity

fun Fragment.getMainActivitySubcomponent(): MainSubcomponent = getMainActivity().mainSubcomponent
