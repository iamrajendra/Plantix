package com.plantix.data.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.plantix.data.database.converters.DateTypeConverter;
import com.plantix.data.database.daos.DatumTableDao;
import com.plantix.data.database.dbpojo.Datum;


//Here initialise daos with respective tables
@Database(entities = {Datum.class}, version = RoomDB.DATABASE_VERSION, exportSchema = false)
@TypeConverters(DateTypeConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    public abstract DatumTableDao datumTableDao();


}
