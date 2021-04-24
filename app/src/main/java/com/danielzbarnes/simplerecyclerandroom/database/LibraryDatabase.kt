package com.danielzbarnes.simplerecyclerandroom.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.danielzbarnes.simplerecyclerandroom.Book


@Database(entities = [Book::class], version = 1)
abstract class LibraryDatabase: RoomDatabase() {

    abstract fun libraryDao(): LibraryDao
}