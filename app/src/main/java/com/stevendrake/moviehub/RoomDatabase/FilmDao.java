package com.stevendrake.moviehub.RoomDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by calebsdrake on 7/1/2018.
 */

@Dao
public interface FilmDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Film film);

    @Query("SELECT * FROM film_table ORDER BY popularity DESC LIMIT 20")
    List<Film> getPopularFilms();

    @Query("SELECT * FROM film_table ORDER BY rating DESC LIMIT 20")
    List<Film> getTopRatedFilms();

//    @Query("SELECT title,poster FROM film_table ORDER BY popularity DESC LIMIT 20")
//    List<Film> getPopularPosters();
//
//    @Query("SELECT title,poster FROM film_table ORDER BY rating DESC LIMIT 20")
//    List<Film> getTopRatedPosters();

    @Query("SELECT title FROM film_table WHERE id = :idIn")
    String getTitle(String idIn);
}