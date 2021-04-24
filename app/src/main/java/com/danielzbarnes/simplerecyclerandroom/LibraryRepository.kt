package com.danielzbarnes.simplerecyclerandroom

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.danielzbarnes.simplerecyclerandroom.database.LibraryDao
import com.danielzbarnes.simplerecyclerandroom.database.LibraryDatabase

private const val LIBRARY_DATABASE = "library-database"

class LibraryRepository private constructor(context: Context){

    private val database:LibraryDatabase = Room.databaseBuilder(context.applicationContext,
        LibraryDatabase::class.java, LIBRARY_DATABASE).build()

    private val libraryDao = database.libraryDao()

    init{
        // init database with library data fetch methods here
    }

    fun getBooks(): LiveData<List<Book>> = libraryDao.getBooks()
    fun getBook(id: String): LiveData<Book?> = libraryDao.getBook(id)

    fun getGenre(): List<String> = libraryDao.getGenre()


    companion object {

        private var INSTANCE: LibraryRepository? = null

        fun initialize(context: Context){
            if(INSTANCE==null) { INSTANCE = LibraryRepository(context) }
        }

        fun get(): LibraryRepository{
            return INSTANCE ?: throw IllegalStateException("LibraryRepository must be initialized.")
        }
    }


}