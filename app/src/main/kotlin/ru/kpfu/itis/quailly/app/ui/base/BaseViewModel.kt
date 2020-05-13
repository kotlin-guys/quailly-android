package ru.kpfu.itis.quailly.app.ui.base

import androidx.annotation.CallSuper
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import ru.kpfu.itis.quailly.app.ui.events.navigation.NavigationCommand
import ru.kpfu.itis.quailly.app.ui.utils.SingleEventLiveData
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), LifecycleObserver, CoroutineScope {

    val errorMessageLiveData = MutableLiveData<String>()
    val progressLiveData = MutableLiveData<Boolean>()

    private val _navigation = SingleEventLiveData<NavigationCommand>()
    val navigation: LiveData<NavigationCommand> = _navigation

    init {
        progressLiveData.value = false
    }

    fun navigate(navigationCommand: NavigationCommand) {
        _navigation.value = navigationCommand
    }

    private val superVisorJob = SupervisorJob()

    final override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + superVisorJob + defaultExceptionHandler

    private val defaultExceptionHandler = CoroutineExceptionHandler { _, exception ->

        handleCoroutineException(exception)
    }

    open fun onNavigationResult(key: String, value: Any) {}

    open fun onBackButtonClicked() {
        _navigation.value = NavigationCommand.Back
    }

    @CallSuper
    protected open fun handleCoroutineException(ex: Throwable) {
    }

    @CallSuper
    override fun onCleared() {
        super.onCleared()

        superVisorJob.cancel()
    }
}
