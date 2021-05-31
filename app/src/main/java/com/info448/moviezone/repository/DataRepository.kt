package com.info448.moviezone.repository


import com.info448.moviezone.model.MovieDetail
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * https://raw.githubusercontent.com/echeeUW/codesnippets/master/email.json
 *
 * https://raw.githubusercontent.com/echeeUW/codesnippets/master/emails.json
 */

class DataRepository {

    private val movieService = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MovieZoneService::class.java)

    suspend fun getMovieDetail(imdbNum: String): MovieDetail = movieService.getMovieDetail(imdbNum)

}

interface MovieZoneService {

    @GET("?type=get-movie-details&")
    @Headers(
        "x-rapidapi-key: 9dc0637ae4msh00919079d6e5317p1b66e0jsn6551d5d0f4e1",
        "x-rapidapi-host: movies-tvshows-data-imdb.p.rapidapi.com"
    )
    suspend fun getMovieDetail(
        @Query("imdb") imdbNum: String,
    ): MovieDetail
}
