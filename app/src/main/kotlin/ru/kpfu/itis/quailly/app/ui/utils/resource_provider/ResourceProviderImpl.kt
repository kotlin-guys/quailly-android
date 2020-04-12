package ru.kpfu.itis.quailly.app.ui.utils.resource_provider

import android.content.Context
import ru.kpfu.itis.quailly.app.ui.utils.resource_provider.ResourceProvider
import javax.inject.Inject

class ResourceProviderImpl @Inject constructor(
    private val context: Context
) : ResourceProvider {

    override fun getString(stringId: Int): String = context.getString(stringId)
}
