    package com.danielzbarnes.simplerecyclerandroom

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

    class LibraryViewModel: ViewModel() {

    private val libraryRepository = LibraryRepository.get()

    val bookListLiveData = libraryRepository.getBooks()

/*  find some excuse to showcase this

    suspend fun getSeriesList(): List<String> =
            withContext(Dispatchers.IO){
                return@withContext sermonRepository.getSeriesList()
            }*/

}