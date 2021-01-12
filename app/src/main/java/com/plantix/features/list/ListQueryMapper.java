package com.plantix.features.list;

import androidx.sqlite.db.SimpleSQLiteQuery;

import com.plantix.data.base.BaseQueryMapper;
import com.plantix.data.database.QueryGenerator;
import com.plantix.data.database.dbpojo.Datum;

public class ListQueryMapper extends BaseQueryMapper {

    public boolean isDataAvailable() {
        return getDb().datumTableDao().isDataAvailable(new QueryGenerator().select().count("id").from(Datum.class).build()) > 0;
    }

    public SimpleSQLiteQuery getAllDataQuery() {
        return new QueryGenerator().select().all().from(Datum.class).build();
    }
}
