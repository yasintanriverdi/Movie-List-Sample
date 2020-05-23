package com.yasintanriverdi.core.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey val id: Int,
    val posterUrl: String?,
    val overview: String?,
    val title: String?
)