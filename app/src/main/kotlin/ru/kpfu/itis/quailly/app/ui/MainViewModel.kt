package ru.kpfu.itis.quailly.app.ui

import ru.kpfu.itis.quailly.app.ui.base.BaseViewModel
import ru.kpfu.itis.quailly.app.ui.utils.SingleEventLiveData
import ru.kpfu.itis.quailly.domain.use_case.auth.IsAuthedUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    isAuthedUseCase: IsAuthedUseCase
) : BaseViewModel() {

    val isAuthed = isAuthedUseCase.execute()
}
