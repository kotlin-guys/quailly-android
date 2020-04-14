package ru.kpfu.itis.quailly.app.ui.auth.start_screen

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.google.android.gms.auth.api.signin.GoogleSignIn
import ru.kpfu.itis.quailly.R
import ru.kpfu.itis.quailly.app.ui.base.BaseFragment
import ru.kpfu.itis.quailly.app.ui.getMainActivitySubcomponent
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelFactory
import ru.kpfu.itis.quailly.databinding.FragmentStartScreenBinding
import javax.inject.Inject

class StartScreenFragment : BaseFragment<FragmentStartScreenBinding, StartScreenViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override val viewModel: StartScreenViewModel by viewModels { viewModelFactory }

    override fun getLayoutResId(): Int = R.layout.fragment_start_screen

    override fun onCreate(savedInstanceState: Bundle?) {
        getMainActivitySubcomponent().startScreenSubcomponentBuilder()
            .build()
            .inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun observeValues() {

        viewModel.gso.observe(this) {
            it?.let { gso ->
                val client = GoogleSignIn.getClient(requireActivity(), gso)
                startActivityForResult(client.signInIntent, 1488)
            }
        }
    }
}
