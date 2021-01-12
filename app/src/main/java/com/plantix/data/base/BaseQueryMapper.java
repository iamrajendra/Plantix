package com.plantix.data.base;


import com.plantix.data.database.AppDatabase;
import com.plantix.data.database.RoomDB;

public class BaseQueryMapper {
    public AppDatabase getDb() {
        return RoomDB.getDefaultInstance();
    }

}
