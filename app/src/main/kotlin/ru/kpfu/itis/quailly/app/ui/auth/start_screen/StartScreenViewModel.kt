package ru.kpfu.itis.quailly.app.ui.auth.start_screen

import androidx.lifecycle.LiveData
import ru.kpfu.itis.quailly.app.ui.base.BaseViewModel
import javax.inject.Inject
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import ru.kpfu.itis.quailly.app.ui.utils.SingleEventLiveData

class StartScreenViewModel @Inject constructor() : BaseViewModel() {

    private val _gso = SingleEventLiveData<GoogleSignInOptions?>()
    val gso: LiveData<GoogleSignInOptions?> = _gso

    fun onSignInButtonClick() {

        val gsoReq = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        _gso.value = gsoReq
    }
}
