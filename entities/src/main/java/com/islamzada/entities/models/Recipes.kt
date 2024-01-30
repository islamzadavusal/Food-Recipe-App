package com.islamzada.entities.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipes(
    val number: Int?,
    val offset: Int?,
    val results: List<Result>?,
    val totalResults: Int?
) : Parcelable