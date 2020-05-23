package com.yasintanriverdi.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yasintanriverdi.core.data.entities.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<Movie>)

    @Query("SELECT * FROM Movie WHERE id = :movieId LIMIT 1")
    suspend fun getMovieById(movieId: Int): Movie?
}