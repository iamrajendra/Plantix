package com.plantix.data.database;

import android.content.Context;

import androidx.room.Room;

import com.plantix.Application;


public class RoomDB {

    public static final String DATABASE_NAME = "plantix";
    public static final int DATABASE_VERSION = 1;
    private static RoomDB ourInstance;
    private AppDatabase appDatabase;

    private RoomDB() {
        Context context = Application.getInstance();
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

    }

    public static AppDatabase getDefaultInstance() {
        if (ourInstance == null) {
            ourInstance = new RoomDB();
        }
        return ourInstance.getAppDatabase();
    }

    private AppDatabase getAppDatabase() {
        return appDatabase;
    }


}
