package com.danielzbarnes.simplerecyclerandroom.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.danielzbarnes.simplerecyclerandroom.Book

@Dao
interface LibraryDao {

    @Query("SELECT * FROM book")
    fun getBooks(): LiveData<List<Book>>

    @Query("SELECT * FROM book WHERE id=(:id)")
    fun getBook(id: String): LiveData<Book?>

    @Query("SELECT genre FROM book")
    fun getGenre(): List<String>

}