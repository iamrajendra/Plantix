package com.plantix.data.database.daos;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SimpleSQLiteQuery;

import com.plantix.data.database.dbpojo.Datum;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public abstract class DatumTableDao extends SuperDao<Datum> {

    @RawQuery(observedEntities = Datum.class)
    public abstract Flowable<List<Datum>> getAllDataFlowable(SimpleSQLiteQuery sqLiteQuery);


    @RawQuery(observedEntities = Datum.class)
    public abstract int isDataAvailable(SimpleSQLiteQuery sqLiteQuery);

    @Query("DELETE FROM Datum")
    public abstract void nukeTable();
}
