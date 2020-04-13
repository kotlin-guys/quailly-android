package ru.kpfu.itis.quailly.app.ui.utils.resource_provider

import androidx.annotation.StringRes

interface ResourceProvider {

    fun getString(@StringRes stringId: Int): String
}