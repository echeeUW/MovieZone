package com.info448.moviezone.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieImage (
    val IMDB: String,
    val fanart: String,
    val poster: String,
    val status: String,
    val status_message: String,
    val title: String
): Parcelable