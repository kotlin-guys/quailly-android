package ru.kpfu.itis.quailly.data.network.model.swipe

import com.google.gson.annotations.SerializedName

data class SwipeReqModel (
    @SerializedName("direction") val direction: String,
    @SerializedName("merchandiseId") val merchandiseId: Int
)