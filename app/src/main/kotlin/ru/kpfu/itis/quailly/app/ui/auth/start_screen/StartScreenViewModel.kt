package ru.kpfu.itis.quailly.app.ui.auth.start_screen

import androidx.lifecycle.LiveData
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import ru.kpfu.itis.quailly.app.ui.base.BaseViewModel
import javax.inject.Inject
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import kotlinx.coroutines.launch
import ru.kpfu.itis.quailly.R
import ru.kpfu.itis.quailly.app.ui.auth.start_screen.mapper.AuthModelMapper
import ru.kpfu.itis.quailly.app.ui.events.navigation.NavigationCommand
import ru.kpfu.itis.quailly.app.ui.utils.SingleEventLiveData
import ru.kpfu.itis.quailly.app.ui.utils.resource_provider.ResourceProvider
import ru.kpfu.itis.quailly.domain.use_case.auth.AuthUseCase

class StartScreenViewModel @Inject constructor(
    private val resProvider: ResourceProvider,
    private val authModelMapper: AuthModelMapper,
    private val authUseCase: AuthUseCase
) : BaseViewModel() {

    private val _gso = SingleEventLiveData<GoogleSignInOptions?>()
    val gso: LiveData<GoogleSignInOptions?> = _gso

    fun onSignInButtonClick() {

        val gsoReq = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        _gso.value = gsoReq
    }

    fun handleAuthSuccess(account: GoogleSignInAccount?) {

        progressLiveData.value = true

        launch {

            account?.let {
                val model = authModelMapper.invoke(it)

                val result = authUseCase.auth(model)

                handleAuthResultFromBack(result)
            }
        }
    }

    fun handleAuthError(message: String?) {
        errorMessageLiveData.value = message ?: resProvider.getString(R.string.error_common)
    }

    private fun handleAuthResultFromBack(result: AuthUseCase.AuthStatus) {
        when (result) {
            AuthUseCase.AuthStatus.EMPTY -> {
                navigate(
                    NavigationCommand.To(
                        StartScreenFragmentDirections.actionStartScreenFragmentToNewItemFragment()
                    )
                )
            }
            AuthUseCase.AuthStatus.NOT_EMPTY -> {
                navigate(
                    NavigationCommand.To(
                        StartScreenFragmentDirections.actionStartScreenFragmentToMainFlowFragment()
                    )
                )
            }
            AuthUseCase.AuthStatus.UNAUTHORIZED -> errorMessageLiveData.value =
                resProvider.getString(R.string.error_common)
        }
    }
}
