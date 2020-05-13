package ru.kpfu.itis.quailly.app.ui.new_item.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoryResult (
    val id: Int,
    val name: String
): Parcelable