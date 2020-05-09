package ru.kpfu.itis.quailly.app.ui.base

import androidx.annotation.CallSuper
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import ru.kpfu.itis.quailly.app.ui.events.navigation.NavigationCommand
import ru.kpfu.itis.quailly.app.ui.utils.SingleEventLiveData
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), LifecycleObserver, CoroutineScope {

    protected val _error = SingleEventLiveData<String>()
    val error: LiveData<String> = _error

    protected val _progress = SingleEventLiveData(false)
    val progress: LiveData<Boolean> = _progress

    protected val _navigation = SingleEventLiveData<NavigationCommand>()
    val navigation: LiveData<NavigationCommand> = _navigation

    fun navigate(directions: NavDirections) {
        _navigation.value = NavigationCommand.To(directions)
    }

    private val superVisorJob = SupervisorJob()

    final override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + superVisorJob + defaultExceptionHandler

    private val defaultExceptionHandler = CoroutineExceptionHandler { _, exception ->

        handleCoroutineException(exception)
    }

    open fun onBackButtonClicked() {
        _navigation.value = NavigationCommand.Back
    }

    @CallSuper
    protected open fun handleCoroutineException(ex: Throwable) { }

    @CallSuper
    override fun onCleared() {
        super.onCleared()

        superVisorJob.cancel()
    }
}
