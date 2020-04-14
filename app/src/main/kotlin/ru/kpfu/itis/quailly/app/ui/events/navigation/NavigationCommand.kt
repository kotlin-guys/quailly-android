package ru.kpfu.itis.quailly.app.ui.events.navigation

import androidx.navigation.NavDirections

sealed class NavigationCommand {

    data class To(val directions: NavDirections): NavigationCommand()

    object Back: NavigationCommand()
}