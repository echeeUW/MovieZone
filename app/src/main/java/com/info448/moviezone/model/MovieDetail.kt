package com.info448.moviezone.model
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
// API Documentation and Sample Response: https://rapidapi.com/amrelrafie/api/movies-tvshows-data-imdb
data class MovieDetail(
    val countries : List<String>,
    val description : String,
    val directors : List<String>,
    val genres : List<String>,
    val imdb_id : String,
    val imdb_rating : String,
    val language : List<String>,
    val popularity : String,
    val rated : String,
    val release_date : String,
    val runtime : Int,
    val stars : List<String>,
    val status: String,
    val status_message: String,
    val title : String,
    val vote_count : String,
    val year : String,
    val youtube_trailer_key : String,
): Parcelable