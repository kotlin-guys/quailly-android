package ru.kpfu.itis.quailly.app.ui.auth.start_screen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import ru.kpfu.itis.quailly.R
import ru.kpfu.itis.quailly.app.ui.base.BaseFragment
import ru.kpfu.itis.quailly.app.ui.getMainActivitySubcomponent
import ru.kpfu.itis.quailly.app.ui.utils.ViewModelFactory
import ru.kpfu.itis.quailly.databinding.FragmentStartScreenBinding
import javax.inject.Inject

class StartScreenFragment : BaseFragment<FragmentStartScreenBinding, StartScreenViewModel>() {

    companion object {
        private const val AUTH_REQ_CODE = 0
    }

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
                startActivityForResult(client.signInIntent, AUTH_REQ_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            AUTH_REQ_CODE -> handleAuthResult(data)
        }
    }

    private fun handleAuthResult(intent: Intent?) {

        val taskWithResult = GoogleSignIn.getSignedInAccountFromIntent(intent)

        try {
            val account = taskWithResult.getResult(ApiException::class.java)
            viewModel.handleAuthSuccess(account)
        } catch (ex: ApiException) {
            viewModel.handleAuthError(ex.localizedMessage)
        }
    }
}
