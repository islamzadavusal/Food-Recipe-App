package com.islamzada.entities.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    val id: Int?,
    val image: String?,
    val imageType: String?,
    val title: String?
) : Parcelable