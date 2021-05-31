package com.info448.moviezone.model

// API Documentation and Sample Response: https://rapidapi.com/amrelrafie/api/movies-tvshows-data-imdb
data class MovieDetail(
    val countries : List<String>,
    val description : String,
    val directors : List<String>,
    val genres : List<String>,
    val imdb_id : String,
    val imdb_rating : Int,
    val language : List<String>,
    val popularity : Float,
    val rated : String,
    val release_date : String,
    val runtime : Int,
    val stars : List<String>,
    val status: String,
    val status_message: String,
    val title : String,
    val vote_count : Int,
    val year : Int,
    val youtube_trailer_key : Int,
)