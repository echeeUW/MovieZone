package com.info448.moviezone.repository

import com.info448.moviezone.model.MovieDetail
import com.info448.moviezone.model.MovieImage
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

class DataRepository {

    val movieService = Retrofit.Builder()
        .baseUrl("https://movies-tvshows-data-imdb.p.rapidapi.com/?")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MovieZoneService::class.java)

    suspend fun getMovieDetail(): MovieDetail = movieService.getMovieDetail()

    suspend fun getMovieImage(): MovieImage = movieService.getMovieImage()

}

interface MovieZoneService {

    @Headers(
        "x-rapidapi-key: 9dc0637ae4msh00919079d6e5317p1b66e0jsn6551d5d0f4e1",
        "x-rapidapi-host: movies-tvshows-data-imdb.p.rapidapi.com"
    )
    @GET("type=get-movie-details&tt0245429&imdb=tt0245429")
    suspend fun getMovieDetail(

        //@Query("imdb") imdb_ID: String
    ): MovieDetail

    @Headers(
        "x-rapidapi-key: 9dc0637ae4msh00919079d6e5317p1b66e0jsn6551d5d0f4e1",
        "x-rapidapi-host: movies-tvshows-data-imdb.p.rapidapi.com"
    )
    @GET("type=get-movie-details&tt0245429&imdb=tt0245429")
    suspend fun getMovieImage(): MovieImage
}
