package com.danielzbarnes.simplerecyclerandroom

import android.app.Application

class LibraryApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        LibraryRepository.initialize(this)
    }
}