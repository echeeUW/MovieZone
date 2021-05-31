package com.info448.moviezone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import coil.load
import com.info448.moviezone.databinding.ActivityMainBinding
import com.info448.moviezone.model.MovieDetail
import com.info448.moviezone.model.MovieImage
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val movieZoneApplication: MovieZoneApplication by lazy {application as MovieZoneApplication}
    private val dataRepository by lazy {movieZoneApplication.dataRepository}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding) {
            btnFetchDetail.setOnClickListener { fetchMovieDetail() }
            btnLoadImage.setOnClickListener { fetchMovieImage() }
        }
    }

    private fun fetchMovieImage() {
        lateinit var movieImage: MovieImage
        lifecycleScope.launch{
            runCatching {
                movieImage = dataRepository.getMovieImage("tt1375666")
            }.onSuccess {
                Log.i("MovieZone", movieImage.toString())
                val secureUrl = movieImage.poster.replace("http", "https")
                binding.ivMovie.load(secureUrl)
            }.onFailure {
                Log.i("MovieZone", "failure")
                Toast.makeText(this@MainActivity, "Request Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun fetchMovieDetail() {
        lateinit var sampleMovie: MovieDetail
        lifecycleScope.launch{
            runCatching {
                sampleMovie = dataRepository.getMovieDetail("tt1375666")
            }.onSuccess {
                Log.i("MovieZone", sampleMovie.toString())
                binding.tvTitle.text = "${sampleMovie.title} (Released in ${sampleMovie.year})"
            }.onFailure {
                Log.i("MovieZone", "failure")
                Toast.makeText(this@MainActivity, "Request Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
