package com.info448.moviezone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.info448.moviezone.model.MovieDetail
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var MovieZoneApp: MovieZoneApplication



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MovieZoneApp = (application as MovieZoneApplication)

        lateinit var sampleMovie: MovieDetail
        lifecycleScope.launch{
            kotlin.runCatching {
                sampleMovie = MovieZoneApp.dataRepository.getMovieDetail()
                Toast.makeText(this@MainActivity, sampleMovie.toString(), Toast.LENGTH_SHORT).show()
            }.onSuccess {
                Log.i("MovieZone App", sampleMovie.toString())
                Toast.makeText(this@MainActivity, sampleMovie.toString(), Toast.LENGTH_SHORT).show()
            }.onFailure {
                Toast.makeText(this@MainActivity, "Request Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}