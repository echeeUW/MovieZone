package com.info448.moviezone.repository

import com.info448.moviezone.model.MovieDetail
import com.info448.moviezone.model.MovieImage
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

class DataRepository {

    val movieService = Retrofit.Builder()
        .baseUrl("https://movies-tvshows-data-imdb.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MovieZoneService::class.java)

    suspend fun getMovieDetail(imbd_ID: String): MovieDetail = movieService.getMovieDetail(imbd_ID)

    suspend fun getMovieImage(imbd_ID: String): MovieImage = movieService.getMovieImage(imbd_ID)

}

interface MovieZoneService {

    @Headers(
        "x-rapidapi-key: 9dc0637ae4msh00919079d6e5317p1b66e0jsn6551d5d0f4e1",
        "x-rapidapi-host: movies-tvshows-data-imdb.p.rapidapi.com"
    )
    @GET("/?type=get-movie-details")
    suspend fun getMovieDetail(@Query("imdb") imdb_ID: String): MovieDetail

    @Headers(
        "x-rapidapi-key: 9dc0637ae4msh00919079d6e5317p1b66e0jsn6551d5d0f4e1",
        "x-rapidapi-host: movies-tvshows-data-imdb.p.rapidapi.com"
    )
    @GET("/?type=get-movies-images-by-imdb")
    suspend fun getMovieImage(@Query("imdb") imdb_ID: String): MovieImage
}
