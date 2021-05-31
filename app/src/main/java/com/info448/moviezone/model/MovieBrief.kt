package com.info448.moviezone.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieBrief(
    val imdb_id: String,
    val title: String,
    val year: Int,
): Parcelable