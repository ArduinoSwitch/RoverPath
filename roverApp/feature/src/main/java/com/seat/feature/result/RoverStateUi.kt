package com.seat.feature.result

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RoverStateUi(
    val position: PointUi,
    val direction: String,
): Parcelable

@Parcelize
data class PointUi(
    val x: Int,
    val y: Int,
): Parcelable
