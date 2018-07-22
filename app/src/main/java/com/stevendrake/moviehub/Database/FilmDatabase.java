package com.stevendrake.moviehub.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by calebsdrake on 7/22/2018.
 */

@Database(entities = {Favorite.class, FavReview.class, FavVideo.class, Film.class, Review.class, Video.class}, version = 1)
public abstract class FilmDatabase extends RoomDatabase {
    public FavoritesDao favoritesDao;
    public FavReviewsDao favReviewsDao;
    public FavVideosDao favVideosDao;
    public FilmDao filmDao;
    public ReviewsDao reviewsDao;
    public VideoDao videoDao;

    private static FilmDatabase INSTANCE;

    static FilmDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (FilmDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), FilmDatabase.class, "film_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}