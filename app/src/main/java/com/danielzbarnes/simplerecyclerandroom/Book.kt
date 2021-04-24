package com.danielzbarnes.simplerecyclerandroom

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Book(
    @PrimaryKey var id: String = "",
    var title:String = "",
    var author: String = "",
    var genre: String = ""
) { }