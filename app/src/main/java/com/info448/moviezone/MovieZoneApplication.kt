package com.info448.moviezone

import android.app.Application
import android.util.Log
import com.info448.moviezone.repository.DataRepository

class MovieZoneApplication: Application() {
    lateinit var dataRepository: DataRepository

    override fun onCreate() {
        super.onCreate()
        dataRepository=DataRepository()
        Log.i("MovieZone App", "MovieZone has booted")
    }
}