package com.info448.moviezone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.info448.moviezone.model.MovieDetail
import com.info448.moviezone.model.MovieImage
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val movieZoneApplication: MovieZoneApplication by lazy {application as MovieZoneApplication}
    private val dataRepository by lazy {movieZoneApplication.dataRepository}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var sampleMovie: MovieDetail
        lateinit var sampleMovieImage: MovieImage
        lifecycleScope.launch{
            runCatching {
                sampleMovieImage = dataRepository.getMovieImage()
                Toast.makeText(this@MainActivity, sampleMovieImage.IMDB, Toast.LENGTH_SHORT).show()
            }.onSuccess {
                Log.i("MovieZone App", sampleMovieImage.IMDB)
                Toast.makeText(this@MainActivity, sampleMovieImage.IMDB, Toast.LENGTH_SHORT).show()
            }.onFailure {
                Toast.makeText(this@MainActivity, "Request Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}