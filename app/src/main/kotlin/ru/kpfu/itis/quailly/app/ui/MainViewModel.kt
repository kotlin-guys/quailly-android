package ru.kpfu.itis.quailly.app.ui

import ru.kpfu.itis.quailly.app.ui.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel() {

    init {
        dealWithAuthState()
    }

    private fun dealWithAuthState() {
        //TODO
    }
}
