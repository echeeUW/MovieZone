package com.info448.moviezone.model
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieList(
    val Total_results: Int,
    val movie_results: List<MovieBrief>,
    val results: Int,
    val status: String,
    val status_message: String,
): Parcelable
